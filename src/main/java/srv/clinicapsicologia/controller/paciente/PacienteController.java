package srv.clinicapsicologia.controller.paciente;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import srv.clinicapsicologia.datasource.model.Paciente;
import srv.clinicapsicologia.datasource.model.Usuario;
import srv.clinicapsicologia.exception.PacienteNotFoundException;
import srv.clinicapsicologia.repository.PacienteRepository;
import srv.clinicapsicologia.repository.PsicologaRepository;
import srv.clinicapsicologia.repository.UsuarioRepository;
import srv.clinicapsicologia.resource.model.PacienteResource;
import srv.clinicapsicologia.service.paciente.BuscarPacientePorId;
import srv.clinicapsicologia.service.paciente.BuscarPacienteService;
import srv.clinicapsicologia.service.paciente.CadastroPaciente;
import srv.clinicapsicologia.service.paciente.EditarPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import srv.clinicapsicologia.datasource.model.StatusPaciente;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/pac")
public class PacienteController {

    @Autowired
    private BuscarPacienteService serviceBuscar;

    @Autowired
    private CadastroPaciente serviceCadastro;

    @Autowired EditarPaciente serviceEditarPaciente;

    @Autowired
    private BuscarPacientePorId serviceBuscarPorId;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PsicologaRepository psicologaRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "pacientes")
    public List<Paciente> listarPacientes() { return serviceBuscar.buscarTodosPacientes(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "paciente/id/{id}")
    public Paciente buscarPacientePorId
            (@PathVariable (name = "id", required = true) Long id) throws PacienteNotFoundException {
        return serviceBuscarPorId.buscarPorId(id);
    }

    @PostMapping(path = "paciente/save")
    public void salvarPaciente(@RequestBody PacienteResource paciente) {
        serviceCadastro.cadastro(paciente);

    }

    @PutMapping(path = "paciente/editar/{id}")
    public void atualizarPaciente(
            @PathVariable(name = "id", required = true) Long id,
            @RequestBody PacienteResource paciente) throws PacienteNotFoundException {
        serviceEditarPaciente.atualizarPaciente(id, paciente);
    }

    @DeleteMapping(path = "paciente/delete/{id}")
    public void deletarPaciente(@PathVariable (name = "id", required = true) Long id) throws PacienteNotFoundException {
        serviceBuscarPorId.deletarPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "pacientes/meus")
    @PreAuthorize("hasRole('PSICOLOGO')")
    public List<Paciente> meusPacientes(Authentication auth) {
        String email = auth.getName();
        Usuario psicologo = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Psicólogo não encontrado"));
        return pacienteRepository.findByPsicologoId(psicologo.getId());
    }

    @GetMapping(path = "pacientes/resumo")
    public ResponseEntity<Map<String, Object>> resumo() {
        List<Paciente> todos = pacienteRepository.findAll();

        long ativos = todos.stream()
                .filter(p -> p.getStatus() == StatusPaciente.ATIVO)
                .count();

        long alta = todos.stream()
                .filter(p -> p.getStatus() == StatusPaciente.ALTA)
                .count();

        Map<String, Long> porPsicologo = todos.stream()
                .filter(p -> p.getPsicologo() != null)
                .collect(Collectors.groupingBy(
                        p -> p.getPsicologo().getNome(),
                        Collectors.counting()
                ));

        return ResponseEntity.ok(Map.of(
                "totalPacientes", todos.size(),
                "ativos", ativos,
                "alta", alta,
                "porPsicologo", porPsicologo
        ));
    }

    @GetMapping(path = "psicologos/total")
    public ResponseEntity<Map<String, Object>> totalPsicologos() {
        long total = psicologaRepository.count();
        return ResponseEntity.ok(Map.of("totalPsicologos", total));
    }
}
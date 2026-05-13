package srv.clinicapsicologia.controller.paciente;

import srv.clinicapsicologia.datasource.model.Paciente;
import srv.clinicapsicologia.exception.PacienteNotFoundException;
import srv.clinicapsicologia.resource.model.PacienteResource;
import srv.clinicapsicologia.service.paciente.BuscarPacientePorId;
import srv.clinicapsicologia.service.paciente.BuscarPacienteService;
import srv.clinicapsicologia.service.paciente.CadastroPaciente;
import srv.clinicapsicologia.service.paciente.EditarPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
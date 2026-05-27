package srv.clinicapsicologia.controller.psicologa;

import srv.clinicapsicologia.datasource.model.Psicologa;
import srv.clinicapsicologia.exception.PsicologaNotFoundException;
import srv.clinicapsicologia.resource.model.PsicologaResource;
import srv.clinicapsicologia.service.psicologa.BuscarPsicologaPorIdService;
import srv.clinicapsicologia.service.psicologa.BuscarPsicologaService;
import srv.clinicapsicologia.service.psicologa.CadastroPsicologa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/psi")
public class PsicologaController {

    @Autowired
    private BuscarPsicologaService serviceBuscar;

    @Autowired
    private CadastroPsicologa serviceCadastro;

    @Autowired
    private BuscarPsicologaPorIdService serviceBuscarPorId;

    @GetMapping(path = "/psicologas")
    public List<Map<String, Object>> buscarPsicologas() {
        return serviceBuscar.buscarTodasAsPsicologas().stream()
                .map(p -> {
                    Map<String, Object> dto = new java.util.HashMap<>();
                    dto.put("id", p.getId());
                    dto.put("nome", p.getNome());
                    dto.put("crPsi", p.getCrPsi());
                    dto.put("usuarioId", p.getUsuario() != null ? p.getUsuario().getId() : null);
                    return dto;
                })
                .collect(java.util.stream.Collectors.toList());
    }

    @GetMapping(path = "/psicologa/id/{id}")
    public Psicologa buscarPsicologaPorId(
            @PathVariable (name = "id", required = true) Long id) throws PsicologaNotFoundException {
        return serviceBuscarPorId.buscarPorId(id);
    }

    @PostMapping(path = "/psicologa/save")
    public void salvarPsicologa(@RequestBody PsicologaResource psicologa) {
        serviceCadastro.cadastro(psicologa);

    }

    @DeleteMapping(path = "psicologa/delete/{id}")
    public void deletarPsicologa(@PathVariable (name = "id", required = true) Long id) throws PsicologaNotFoundException {
        serviceBuscarPorId.deletarPorId(id);
    }
}
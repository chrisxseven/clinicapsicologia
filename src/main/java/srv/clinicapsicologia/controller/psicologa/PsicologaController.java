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

@RestController
@RequestMapping(value = "/psi")
public class PsicologaController {

    @Autowired
    private BuscarPsicologaService serviceBuscar;

    @Autowired
    private CadastroPsicologa serviceCadastro;

    @Autowired
    private BuscarPsicologaPorIdService serviceBuscarPorId;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/psicologas")
    public List<Psicologa> buscarPsicologas() {
        return serviceBuscar.buscarTodasAsPsicologas();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/psicologa/id/{id}")
    public Psicologa buscarPsicologaPorId(
            @PathVariable (name = "id", required = true) Long id) throws PsicologaNotFoundException {
        return serviceBuscarPorId.buscarPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/psicologa/save")
    public void salvarPsicologa(@RequestBody PsicologaResource psicologa) {
        serviceCadastro.cadastro(psicologa);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "psicologa/delete/{id}")
    public void deletarPsicologa(@PathVariable (name = "id", required = true) Long id) throws PsicologaNotFoundException {
        serviceBuscarPorId.deletarPorId(id);
    }
}
package srv.clinicapsicologia.service.psicologa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import srv.clinicapsicologia.datasource.model.Psicologa;
import srv.clinicapsicologia.repository.PsicologaRepository;

import java.util.List;

@Service
public class BuscarPsicologaService {

    @Autowired
    private PsicologaRepository psicologaRepository;

    public List<Psicologa> buscarTodasAsPsicologas() {
        List<Psicologa> listPsicologa = psicologaRepository.findAll();
        return listPsicologa;
    }
}
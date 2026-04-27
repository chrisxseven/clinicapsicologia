package srv.clinicapsicologia.service.psicologa;

import srv.clinicapsicologia.repository.PsicologaRepository;
import srv.clinicapsicologia.datasource.model.Psicologa;
import srv.clinicapsicologia.exception.PsicologaResourceException;
import srv.clinicapsicologia.resource.model.PsicologaResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPsicologa {

    private static final Logger LOG = LoggerFactory.getLogger(CadastroPsicologa.class);

    @Autowired
    private PsicologaRepository psicologaRepository;

    @Autowired
    private PsicologaConversor service;

    public void cadastro(PsicologaResource psicologaResource) {

        try {
            Psicologa psicologa = service
                    .conversor(psicologaResource);
            psicologaRepository.saveAndFlush(psicologa);
        } catch (PsicologaResourceException e) {
            LOG.error("Erro ao salvar psicologa: {}", e.getMessage(), e);
        }
    }
}
package srv.clinicapsicologia.service.psicologa;

import srv.clinicapsicologia.repository.PsicologaRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPsicologa {

    private static final Logger LOG = Logger
            .getLogger(CadastroPsicologa.class);

    @Autowired
    private PsicologaRepository psicologaRepository;


}
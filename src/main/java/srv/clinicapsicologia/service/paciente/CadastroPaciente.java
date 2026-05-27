package srv.clinicapsicologia.service.paciente;

import srv.clinicapsicologia.datasource.model.Paciente;
import srv.clinicapsicologia.datasource.model.Usuario;
import srv.clinicapsicologia.exception.PacienteResourceException;
import srv.clinicapsicologia.repository.PacienteRepository;
import srv.clinicapsicologia.repository.UsuarioRepository;
import srv.clinicapsicologia.resource.model.PacienteResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPaciente {

    private static final Logger LOG = LoggerFactory.getLogger(CadastroPaciente.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteConversor service;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastro(PacienteResource pacienteResource) {

        try {
            Paciente paciente = service.conversor(pacienteResource);

            if (pacienteResource.getPsicologoId() != null) {
                Usuario psicologo = usuarioRepository
                        .findById(pacienteResource.getPsicologoId())
                        .orElseThrow(() -> new RuntimeException("Psicólogo não encontrado"));
                paciente.setPsicologo(psicologo);
            }

            pacienteRepository.saveAndFlush(paciente);
        } catch (PacienteResourceException e) {
            LOG.error("Erro ao salvar paciente: {}", e.getMessage(), e);
        }
    }
}
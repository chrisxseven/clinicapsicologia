package srv.clinicapsicologia.service.paciente;

import srv.clinicapsicologia.datasource.model.Paciente;
import srv.clinicapsicologia.exception.PacienteResourceException;
import srv.clinicapsicologia.repository.PacienteRepository;
import srv.clinicapsicologia.resource.model.PacienteResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarPaciente {

    private static final Logger LOG = LoggerFactory.getLogger(EditarPaciente.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteConversor service;


    public void atualizarPaciente(Long id, PacienteResource pacienteResource) {
        try {
            Paciente existente = pacienteRepository.findById(id)
                    .orElseThrow(() -> new PacienteResourceException("Paciente não encontrado: " + id));

            existente.setNome(pacienteResource.getNome());
            existente.setCpfPaciente(pacienteResource.getCpfPaciente());
            existente.setTelefone(pacienteResource.getTelefone());
            existente.setDataNascimento(pacienteResource.getDataNascimento());
            existente.setTipoTerapia(pacienteResource.getTipoTerapia());

            pacienteRepository.saveAndFlush(existente);
        } catch (PacienteResourceException e) {
            LOG.error("Erro ao atualizar paciente: {}", e.getMessage(), e);
        }
    }
}
package srv.clinicapsicologia.service.paciente;

import srv.clinicapsicologia.datasource.model.Paciente;
import srv.clinicapsicologia.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> buscarTodosPacientes () {
        List<Paciente> listPaciente = pacienteRepository.findAll();
        return listPaciente;
    }
}

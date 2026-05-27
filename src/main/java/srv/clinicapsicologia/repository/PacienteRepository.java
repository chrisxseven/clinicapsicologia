package srv.clinicapsicologia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import srv.clinicapsicologia.datasource.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository
        extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findById(Long idPaciente);

    List<Paciente> findByPsicologoId(Long psicologoId);
}

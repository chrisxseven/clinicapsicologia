package srv.clinicapsicologia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import srv.clinicapsicologia.datasource.model.Psicologa;

import java.util.Optional;

public interface PsicologaRepository
        extends JpaRepository<Psicologa, Long> {
    Optional<Psicologa> findById(Long idPsicologa);
    Optional<Psicologa> findByUsuarioEmail(String email);
}
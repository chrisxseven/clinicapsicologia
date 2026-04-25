package srv.clinicapsicologia.service.psicologa;

import srv.clinicapsicologia.datasource.model.Psicologa;
import srv.clinicapsicologia.exception.PsicologaResourceException;
import srv.clinicapsicologia.resource.model.PsicologaResource;
import org.springframework.stereotype.Component;

@Component
public class PsicologaConversor {

    public Psicologa conversor(PsicologaResource psicologaResource)
            throws PsicologaResourceException {

        try {
            if (psicologaResource == null) {
                throw new PsicologaResourceException("Resource não pode ser nulo.");
            }

            Long idPsicologa = checkIdPsicologa(psicologaResource.getIdPsicologa());

            Psicologa psicologa = new Psicologa();
            psicologa.setIdPsicologa(idPsicologa);
            psicologa.setCrPsi(psicologaResource.getCrPsi());
            psicologa.setNome(psicologaResource.getNome());

            return psicologa;

        } catch (Exception e) {
            throw new PsicologaResourceException("Falha ao converter resource para entidade, resource: " + psicologaResource, e);
        }
    }

    private Long checkIdPsicologa(String idPsicologa) {
        if (idPsicologa == null || idPsicologa.isBlank()) {
            return null;
        }
        try {
            return Long.parseLong(idPsicologa);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID da Psicologa inválido: " + idPsicologa);
        }
    }
}

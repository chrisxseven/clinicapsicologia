package srv.clinicapsicologia.service.psicologa;

import org.springframework.security.crypto.password.PasswordEncoder;
import srv.clinicapsicologia.datasource.model.Role;
import srv.clinicapsicologia.datasource.model.Usuario;
import srv.clinicapsicologia.repository.PsicologaRepository;
import srv.clinicapsicologia.datasource.model.Psicologa;
import srv.clinicapsicologia.exception.PsicologaResourceException;
import srv.clinicapsicologia.repository.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PsicologaConversor service;

    public void cadastro(PsicologaResource psicologaResource) {

        try {
            Usuario usuario = new Usuario();
            usuario.setNome(psicologaResource.getNome());
            usuario.setEmail(psicologaResource.getEmail());
            usuario.setSenha(passwordEncoder.encode("Clinica@2026"));
            usuario.setRole(Role.PSICOLOGO);
            usuarioRepository.save(usuario);

            Psicologa psicologa = service.conversor(psicologaResource);
            psicologa.setUsuario(usuario);
            psicologaRepository.saveAndFlush(psicologa);
        } catch (PsicologaResourceException e) {
            LOG.error("Erro ao salvar psicologa: {}", e.getMessage(), e);
        }
    }
}
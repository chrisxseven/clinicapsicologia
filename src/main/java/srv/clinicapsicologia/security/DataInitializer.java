package srv.clinicapsicologia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import srv.clinicapsicologia.datasource.model.Role;
import srv.clinicapsicologia.datasource.model.Usuario;
import srv.clinicapsicologia.repository.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.senha}")
    private String adminSenha;

    @Override
    public void run(String... args) throws Exception {

        if (usuarioRepository.findByEmail(adminEmail).isEmpty()) {
            Usuario superAdmin = new Usuario();
            superAdmin.setNome("Administrador Supremo");

            superAdmin.setEmail(adminEmail);
            superAdmin.setSenha(passwordEncoder.encode(adminSenha));

            superAdmin.setRole(Role.SUPERADMIN);

            usuarioRepository.save(superAdmin);
            System.out.println("Super Admin criado com sucesso!");
        }
    }
}
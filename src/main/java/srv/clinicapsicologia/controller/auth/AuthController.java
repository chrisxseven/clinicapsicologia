package srv.clinicapsicologia.controller.auth;

import srv.clinicapsicologia.datasource.model.Usuario;
import srv.clinicapsicologia.repository.UsuarioRepository;
import srv.clinicapsicologia.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(body.get("email"), body.get("senha"))
            );
            String token = jwtService.gerarToken(body.get("email"));

            Usuario usuario = usuarioRepository.findByEmail(body.get("email"))
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "nome", usuario.getNome()
            ));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(Map.of("erro", "Email ou senha inválidos."));
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Map<String, String> body) {
        try {
            if (!body.containsKey("nome") || body.get("nome").trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("erro", "O nome é obrigatório."));
            }

            if (!body.containsKey("email") || body.get("email").trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("erro", "O email é obrigatório."));
            }

            if (!body.containsKey("senha") || body.get("senha").trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("erro", "A senha é obrigatória."));
            }

            if (usuarioRepository.findByEmail(body.get("email")).isPresent()) {
                return ResponseEntity.badRequest().body(Map.of("erro", "Email já cadastrado."));
            }

            Usuario u = new Usuario();
            u.setNome(body.get("nome"));
            u.setEmail(body.get("email"));
            u.setSenha(passwordEncoder.encode(body.get("senha")));

            // Define a role: se informada na requisição, usa essa; senão, padrão é "USER"
            String role = body.getOrDefault("role", "USER").toUpperCase();

            // Validação: apenas "USER" ou "ADMIN" são permitidas
            if (!role.equals("USER") && !role.equals("ADMIN")) {
                return ResponseEntity.badRequest().body(Map.of("erro", "Role inválida. Use 'USER' ou 'ADMIN'."));
            }

            u.setRole(role);
            usuarioRepository.save(u);

            return ResponseEntity.ok(Map.of(
                    "mensagem", "Usuário criado com sucesso.",
                    "role", role,
                    "nome", u.getNome(),
                    "email", u.getEmail()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("erro", "Erro ao criar conta: " + e.getMessage()));
        }
    }
}

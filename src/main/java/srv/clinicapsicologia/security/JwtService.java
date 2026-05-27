package srv.clinicapsicologia.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import srv.clinicapsicologia.datasource.model.Usuario;
import srv.clinicapsicologia.repository.UsuarioRepository;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET = "clinica-secret-key-super-segura-2026!!";
    private static final long EXPIRATION = 86400000;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String gerarToken(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)  // busca aqui
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return Jwts.builder()
                .setSubject(email)
                .claim("role", usuario.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extrairEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String extrairRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

    public boolean tokenValido(String token) {
        try {
            extrairEmail(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}

package srv.clinicapsicologia.datasource.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "psicologa")
public class Psicologa implements Serializable{

    @Serial
    private static final long serialVersionUID = 8953580099424581835L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name = "cr_psi")
    private String crPsi;

    @Column(name = "id_psicologa")
    private Long idPsicologa;

    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;

    public Psicologa() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrPsi() {
        return crPsi;
    }

    public void setCrPsi(String crPsi) {
        this.crPsi = crPsi;
    }

    public Long getIdPsicologa() {
        return idPsicologa;
    }

    public void setIdPsicologa(Long idPsicologa) {
        this.idPsicologa = idPsicologa;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
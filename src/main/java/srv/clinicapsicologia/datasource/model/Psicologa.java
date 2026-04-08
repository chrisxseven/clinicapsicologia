package srv.clinicapsicologia.datasource.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

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

    public Psicologa() {

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
}
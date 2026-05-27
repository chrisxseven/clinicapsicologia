package srv.clinicapsicologia.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PsicologaResource {

    @JsonProperty("nome_psicologa")
    private String nome;

    @JsonProperty("cr_psi")
    private String crPsi;

    @JsonProperty("id_psicologa")
    private String idPsicologa;

    @JsonProperty("email")
    private String email;

    public PsicologaResource(String nome, String crPsi, String idPsicologa, String email) {
        this.nome = nome;
        this.crPsi = crPsi;
        this.idPsicologa = idPsicologa;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrPsi() { return crPsi; }

    public void setCrPsi(String crPsi) {
        this.crPsi = crPsi;
    }

    public String getIdPsicologa() {
        return idPsicologa;
    }

    public void setIdPsicologa(String idPsicologa) {
        this.idPsicologa = idPsicologa;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "PsicologaResource [nome=" + nome + ", crPsi=" + crPsi + ", idPsicologa=" + idPsicologa + ", email=" + email + "]";
    }
}

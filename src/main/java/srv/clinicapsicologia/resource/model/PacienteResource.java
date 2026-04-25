package srv.clinicapsicologia.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PacienteResource {

    @JsonProperty("nome_paciente")
    private String nome;

    @JsonProperty
    private String idPaciente;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @JsonProperty("cpf_paciente")
    private String cpfPaciente;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("data_cadastro")
    private LocalDate dataCadastro;

    @JsonProperty("tipo_terapia")
    private String tipoTerapia;

    public PacienteResource(String nome, LocalDate data_nascimento, String cpf, String telefone, LocalDate data_cadastro, String tipo_terapia) {
        this.nome = nome;
        this.idPaciente = idPaciente;
        this.dataNascimento = data_nascimento;
        this.cpfPaciente = cpf;
        this.telefone = telefone;
        this.dataCadastro = data_cadastro;
        this.tipoTerapia = tipo_terapia;
    }

    public PacienteResource() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdPaciente() { return idPaciente; }

    public void setIdPaciente(String idPaciente) {}

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTipoTerapia() {
        return tipoTerapia;
    }

    public void setTipoTerapia(String tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }

    @Override
    public String toString() {
        return "PacienteResource{" +
                "nome='" + nome + '\'' +
                ", idPaciente='" + idPaciente + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", tipoTerapia='" + tipoTerapia + '\'' +
                '}';
    }
}

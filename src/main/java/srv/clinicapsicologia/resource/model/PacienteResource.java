package srv.clinicapsicologia.resource.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @JsonProperty("data_agendamento")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAgendamento;

    @JsonProperty("tipo_terapia")
    private String tipoTerapia;

    public PacienteResource(String nome, LocalDate data_nascimento, String cpf, String telefone, LocalDate data_cadastro, LocalDateTime data_agendamento, String tipo_terapia) {
        this.nome = nome;
        this.idPaciente = idPaciente;
        this.dataNascimento = data_nascimento;
        this.cpfPaciente = cpf;
        this.telefone = telefone;
        this.dataCadastro = data_cadastro;
        this.dataAgendamento = data_agendamento;
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

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
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
                ", dataAgendamento=" + dataAgendamento +
                ", tipoTerapia='" + tipoTerapia + '\'' +
                '}';
    }
}

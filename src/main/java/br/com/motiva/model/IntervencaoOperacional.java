package br.com.motiva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "INTERVENCAO_OPERACIONAL")
public class IntervencaoOperacional {

    @Id
    @SequenceGenerator(
        name = "seq_intervencao_operacional",
        sequenceName = "SEQ_INTERVENCAO_OPERACIONAL",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_intervencao_operacional"
    )
    private Long id;

    @NotBlank(message = "O tipo da intervenção é obrigatório")
    @Column(name = "TIPO", nullable = false, length = 30)
    private String tipo;

    @NotBlank(message = "A equipe responsável é obrigatória")
    @Column(name = "EQUIPE_RESPONSAVEL", nullable = false, length = 100)
    private String equipeResponsavel;

    public IntervencaoOperacional() {
    }

    public IntervencaoOperacional(String tipo, String equipeResponsavel) {
        this.tipo = tipo;
        this.equipeResponsavel = equipeResponsavel;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEquipeResponsavel() {
        return equipeResponsavel;
    }

    public void setEquipeResponsavel(String equipeResponsavel) {
        this.equipeResponsavel = equipeResponsavel;
    }
}
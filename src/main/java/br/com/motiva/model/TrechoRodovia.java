package br.com.motiva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "TRECHO_RODOVIA")
public class TrechoRodovia {

    @Id
    @SequenceGenerator(
        name = "seq_trecho_rodovia",
        sequenceName = "SEQ_TRECHO_RODOVIA",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_trecho_rodovia"
    )
    private Long id;

    @NotNull(message = "O quilômetro é obrigatório")
    @PositiveOrZero(message = "O quilômetro não pode ser negativo")
    @Column(name = "KM", nullable = false)
    private Double km;

    @NotNull(message = "O nível de vegetação é obrigatório")
    @PositiveOrZero(message = "O nível de vegetação não pode ser negativo")
    @Column(name = "NIVEL_VEGETACAO", nullable = false)
    private Double nivelVegetacao;

    @NotNull(message = "O tipo do trecho é obrigatório")
    @Column(name = "TIPO", nullable = false, length = 20)
    private String tipo;

    public TrechoRodovia() {
    }

    public TrechoRodovia(Double km, Double nivelVegetacao, String tipo) {
        this.km = km;
        this.nivelVegetacao = nivelVegetacao;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public Double getNivelVegetacao() {
        return nivelVegetacao;
    }

    public void setNivelVegetacao(Double nivelVegetacao) {
        this.nivelVegetacao = nivelVegetacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
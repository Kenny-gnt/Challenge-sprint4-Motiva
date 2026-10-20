package br.com.motiva.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotBlank;

public class TrechoDTO {

    private Long id;

    @NotNull(message = "O quilômetro é obrigatório")
    @PositiveOrZero(message = "O quilômetro não pode ser negativo")
    private Double km;

    @NotNull(message = "O nível de vegetação é obrigatório")
    @PositiveOrZero(message = "O nível de vegetação não pode ser negativo")
    private Double nivelVegetacao;

    @NotBlank(message = "O tipo do trecho é obrigatório")
    private String tipo;

    public TrechoDTO() {
    }

    public TrechoDTO(Long id, Double km, Double nivelVegetacao, String tipo) {
        this.id = id;
        this.km = km;
        this.nivelVegetacao = nivelVegetacao;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getKm() { return km; }
    public void setKm(Double km) { this.km = km; }

    public Double getNivelVegetacao() { return nivelVegetacao; }
    public void setNivelVegetacao(Double nivelVegetacao) {
        this.nivelVegetacao = nivelVegetacao;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}

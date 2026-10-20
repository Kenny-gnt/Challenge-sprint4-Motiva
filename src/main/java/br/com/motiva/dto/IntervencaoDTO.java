package br.com.motiva.dto;

import jakarta.validation.constraints.NotBlank;

public class IntervencaoDTO {

    private Long id;

    @NotBlank(message = "O tipo da intervenção é obrigatório")
    private String tipo;

    @NotBlank(message = "A equipe responsável é obrigatória")
    private String equipeResponsavel;

    public IntervencaoDTO() {
    }

    public IntervencaoDTO(Long id, String tipo, String equipeResponsavel) {
        this.id = id;
        this.tipo = tipo;
        this.equipeResponsavel = equipeResponsavel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEquipeResponsavel() { return equipeResponsavel; }
    public void setEquipeResponsavel(String equipeResponsavel) {
        this.equipeResponsavel = equipeResponsavel;
    }
}

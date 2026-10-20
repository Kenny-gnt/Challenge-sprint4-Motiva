package br.com.motiva.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EquipeDTO {

    private Long id;

    @NotBlank(message = "O nome da equipe é obrigatório")
    private String nomeEquipe;

    @NotNull(message = "A quantidade de funcionários é obrigatória")
    @Positive(message = "A equipe deve ter pelo menos um funcionário")
    private Integer quantidadeFuncionarios;

    public EquipeDTO() {
    }

    public EquipeDTO(Long id, String nomeEquipe, Integer quantidadeFuncionarios) {
        this.id = id;
        this.nomeEquipe = nomeEquipe;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeEquipe() { return nomeEquipe; }
    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public Integer getQuantidadeFuncionarios() { return quantidadeFuncionarios; }
    public void setQuantidadeFuncionarios(Integer quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
}

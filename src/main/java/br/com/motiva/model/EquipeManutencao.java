package br.com.motiva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "EQUIPE_MANUTENCAO")
public class EquipeManutencao {

    @Id
    @SequenceGenerator(
        name = "seq_equipe_manutencao",
        sequenceName = "SEQ_EQUIPE_MANUTENCAO",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_equipe_manutencao"
    )
    private Long id;

    @NotBlank(message = "O nome da equipe é obrigatório")
    @Column(name = "NOME_EQUIPE", nullable = false, length = 100)
    private String nomeEquipe;

    @NotNull(message = "A quantidade de funcionários é obrigatória")
    @Positive(message = "A equipe deve ter pelo menos um funcionário")
    @Column(name = "QUANTIDADE_FUNCIONARIOS", nullable = false)
    private Integer quantidadeFuncionarios;

    public EquipeManutencao() {
    }

    public EquipeManutencao(String nomeEquipe, Integer quantidadeFuncionarios) {
        this.nomeEquipe = nomeEquipe;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public Long getId() {
        return id;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public Integer getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(Integer quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
}
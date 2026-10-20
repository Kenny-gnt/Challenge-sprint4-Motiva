package br.com.motiva.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "RELATORIO_PRIORIDADE")
public class RelatorioPrioridade {

    @Id
    @SequenceGenerator(
        name = "seq_relatorio_prioridade",
        sequenceName = "SEQ_RELATORIO_PRIORIDADE",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_relatorio_prioridade"
    )
    private Long id;

    @Column(name = "DATA_RELATORIO", nullable = false)
    private LocalDateTime dataRelatorio;

    @Column(name = "QT_URGENTE", nullable = false)
    private Integer qtUrgente;

    @Column(name = "QT_CRITICO", nullable = false)
    private Integer qtCritico;

    @Column(name = "QT_ATENCAO", nullable = false)
    private Integer qtAtencao;

    @Column(name = "QT_NORMAL", nullable = false)
    private Integer qtNormal;

    @Column(name = "RESUMO", length = 500)
    private String resumo;

    public RelatorioPrioridade() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(LocalDateTime dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public Integer getQtUrgente() {
        return qtUrgente;
    }

    public void setQtUrgente(Integer qtUrgente) {
        this.qtUrgente = qtUrgente;
    }

    public Integer getQtCritico() {
        return qtCritico;
    }

    public void setQtCritico(Integer qtCritico) {
        this.qtCritico = qtCritico;
    }

    public Integer getQtAtencao() {
        return qtAtencao;
    }

    public void setQtAtencao(Integer qtAtencao) {
        this.qtAtencao = qtAtencao;
    }

    public Integer getQtNormal() {
        return qtNormal;
    }

    public void setQtNormal(Integer qtNormal) {
        this.qtNormal = qtNormal;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}
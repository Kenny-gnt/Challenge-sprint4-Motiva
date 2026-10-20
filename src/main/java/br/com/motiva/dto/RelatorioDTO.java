package br.com.motiva.dto;

import java.time.LocalDateTime;

public class RelatorioDTO {

    private Long id;
    private LocalDateTime dataRelatorio;
    private Integer qtUrgente;
    private Integer qtCritico;
    private Integer qtAtencao;
    private Integer qtNormal;
    private String resumo;

    public RelatorioDTO() {
    }

    public RelatorioDTO(Long id, LocalDateTime dataRelatorio,
            Integer qtUrgente, Integer qtCritico,
            Integer qtAtencao, Integer qtNormal, String resumo) {
        this.id = id;
        this.dataRelatorio = dataRelatorio;
        this.qtUrgente = qtUrgente;
        this.qtCritico = qtCritico;
        this.qtAtencao = qtAtencao;
        this.qtNormal = qtNormal;
        this.resumo = resumo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataRelatorio() { return dataRelatorio; }
    public void setDataRelatorio(LocalDateTime dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public Integer getQtUrgente() { return qtUrgente; }
    public void setQtUrgente(Integer qtUrgente) { this.qtUrgente = qtUrgente; }

    public Integer getQtCritico() { return qtCritico; }
    public void setQtCritico(Integer qtCritico) { this.qtCritico = qtCritico; }

    public Integer getQtAtencao() { return qtAtencao; }
    public void setQtAtencao(Integer qtAtencao) { this.qtAtencao = qtAtencao; }

    public Integer getQtNormal() { return qtNormal; }
    public void setQtNormal(Integer qtNormal) { this.qtNormal = qtNormal; }

    public String getResumo() { return resumo; }
    public void setResumo(String resumo) { this.resumo = resumo; }
}

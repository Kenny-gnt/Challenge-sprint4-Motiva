package br.com.motiva.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.motiva.model.RelatorioPrioridade;
import br.com.motiva.model.TrechoRodovia;
import br.com.motiva.repository.RelatorioPrioridadeRepository;
import br.com.motiva.repository.TrechoRodoviaRepository;

@Service
public class RelatorioPrioridadeService {

    private final RelatorioPrioridadeRepository relatorioRepository;
    private final TrechoRodoviaRepository trechoRepository;

    public RelatorioPrioridadeService(
            RelatorioPrioridadeRepository relatorioRepository,
            TrechoRodoviaRepository trechoRepository) {
        this.relatorioRepository = relatorioRepository;
        this.trechoRepository = trechoRepository;
    }

    @Transactional
    public RelatorioPrioridade gerarRelatorio() {
        List<TrechoRodovia> trechos = trechoRepository.findAll();

        int qtUrgente = 0;
        int qtCritico = 0;
        int qtAtencao = 0;
        int qtNormal = 0;

        for (TrechoRodovia trecho : trechos) {
            double nivel = trecho.getNivelVegetacao();

            if (nivel >= 8) {
                qtUrgente++;
            } else if (nivel >= 6) {
                qtCritico++;
            } else if (nivel >= 4) {
                qtAtencao++;
            } else {
                qtNormal++;
            }
        }

        RelatorioPrioridade relatorio = new RelatorioPrioridade();
        relatorio.setDataRelatorio(LocalDateTime.now());
        relatorio.setQtUrgente(qtUrgente);
        relatorio.setQtCritico(qtCritico);
        relatorio.setQtAtencao(qtAtencao);
        relatorio.setQtNormal(qtNormal);
        relatorio.setResumo("Relatório gerado para " + trechos.size()
                + " trechos rodoviários.");

        return relatorioRepository.save(relatorio);
    }

    public List<RelatorioPrioridade> listarHistorico() {
        return relatorioRepository.findAll();
    }

    public List<RelatorioPrioridade> buscarPorPeriodo(
            LocalDateTime inicio, LocalDateTime fim) {
        if (inicio.isAfter(fim)) {
            throw new IllegalArgumentException(
                    "A data inicial não pode ser posterior à data final.");
        }

        return relatorioRepository
                .findByDataRelatorioBetweenOrderByDataRelatorioDesc(inicio, fim);
    }
}
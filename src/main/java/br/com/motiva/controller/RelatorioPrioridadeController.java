package br.com.motiva.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.motiva.dto.RelatorioDTO;
import br.com.motiva.model.RelatorioPrioridade;
import br.com.motiva.service.RelatorioPrioridadeService;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioPrioridadeController {

    private final RelatorioPrioridadeService service;

    public RelatorioPrioridadeController(RelatorioPrioridadeService service) {
        this.service = service;
    }

    private RelatorioDTO converter(RelatorioPrioridade r) {
        return new RelatorioDTO(
                r.getId(),
                r.getDataRelatorio(),
                r.getQtUrgente(),
                r.getQtCritico(),
                r.getQtAtencao(),
                r.getQtNormal(),
                r.getResumo()
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RelatorioDTO gerarRelatorio() {
        return converter(service.gerarRelatorio());
    }

    @GetMapping
    public List<RelatorioDTO> listarHistorico() {
        return service.listarHistorico()
                .stream()
                .map(this::converter)
                .toList();
    }

    @GetMapping("/periodo")
    public List<RelatorioDTO> buscarPorPeriodo(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime inicio,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime fim) {
        return service.buscarPorPeriodo(inicio, fim)
                .stream()
                .map(this::converter)
                .toList();
    }
}

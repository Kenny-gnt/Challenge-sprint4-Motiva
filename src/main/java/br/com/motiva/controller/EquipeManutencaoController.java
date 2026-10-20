package br.com.motiva.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.motiva.dto.EquipeDTO;
import br.com.motiva.model.EquipeManutencao;
import br.com.motiva.service.EquipeManutencaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/equipes")
public class EquipeManutencaoController {

    private final EquipeManutencaoService service;

    public EquipeManutencaoController(EquipeManutencaoService service) {
        this.service = service;
    }

    private EquipeDTO converter(EquipeManutencao equipe) {
        return new EquipeDTO(
                equipe.getId(),
                equipe.getNomeEquipe(),
                equipe.getQuantidadeFuncionarios()
        );
    }

    private EquipeManutencao converter(EquipeDTO dto) {
        return new EquipeManutencao(
                dto.getNomeEquipe(),
                dto.getQuantidadeFuncionarios()
        );
    }

    @GetMapping
    public List<EquipeDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(this::converter)
                .toList();
    }

    @GetMapping("/{id}")
    public EquipeDTO buscarPorId(@PathVariable Long id) {
        return converter(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EquipeDTO cadastrar(@Valid @RequestBody EquipeDTO dto) {
        return converter(service.cadastrar(converter(dto)));
    }

    @PutMapping("/{id}")
    public EquipeDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EquipeDTO dto) {
        return converter(service.atualizar(id, converter(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

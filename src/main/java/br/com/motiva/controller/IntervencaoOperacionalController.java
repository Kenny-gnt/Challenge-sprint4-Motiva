package br.com.motiva.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.motiva.dto.IntervencaoDTO;
import br.com.motiva.model.IntervencaoOperacional;
import br.com.motiva.service.IntervencaoOperacionalService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/intervencoes")
public class IntervencaoOperacionalController {

    private final IntervencaoOperacionalService service;

    public IntervencaoOperacionalController(
            IntervencaoOperacionalService service) {
        this.service = service;
    }

    private IntervencaoDTO converter(IntervencaoOperacional item) {
        return new IntervencaoDTO(
                item.getId(), item.getTipo(), item.getEquipeResponsavel());
    }

    private IntervencaoOperacional converter(IntervencaoDTO dto) {
        return new IntervencaoOperacional(
                dto.getTipo(), dto.getEquipeResponsavel());
    }

    @GetMapping
    public List<IntervencaoDTO> listarTodos() {
        return service.listarTodos().stream().map(this::converter).toList();
    }

    @GetMapping("/{id}")
    public IntervencaoDTO buscarPorId(@PathVariable Long id) {
        return converter(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IntervencaoDTO cadastrar(@Valid @RequestBody IntervencaoDTO dto) {
        return converter(service.cadastrar(converter(dto)));
    }

    @PutMapping("/{id}")
    public IntervencaoDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody IntervencaoDTO dto) {
        return converter(service.atualizar(id, converter(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

package br.com.motiva.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.motiva.dto.TrechoDTO;
import br.com.motiva.model.TrechoRodovia;
import br.com.motiva.service.TrechoRodoviaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trechos")
public class TrechoRodoviaController {

    private final TrechoRodoviaService service;

    public TrechoRodoviaController(TrechoRodoviaService service) {
        this.service = service;
    }

    private TrechoDTO converter(TrechoRodovia trecho) {
        return new TrechoDTO(
                trecho.getId(),
                trecho.getKm(),
                trecho.getNivelVegetacao(),
                trecho.getTipo()
        );
    }

    private TrechoRodovia converter(TrechoDTO dto) {
        TrechoRodovia trecho = new TrechoRodovia(
                dto.getKm(),
                dto.getNivelVegetacao(),
                dto.getTipo()
        );
        return trecho;
    }

    @GetMapping
    public List<TrechoDTO> listarTodos() {
        return service.listarTodos()
                .stream()
                .map(this::converter)
                .toList();
    }

    @GetMapping("/tipo/{tipo}")
    public List<TrechoDTO> buscarPorTipo(@PathVariable String tipo) {
        return service.buscarPorTipo(tipo)
                .stream()
                .map(this::converter)
                .toList();
    }

    @GetMapping("/vegetacao/{minimo}")
    public List<TrechoDTO> buscarPorVegetacao(@PathVariable Double minimo) {
        return service.buscarPorNivelVegetacao(minimo)
                .stream()
                .map(this::converter)
                .toList();
    }

    @GetMapping("/{id}")
    public TrechoDTO buscarPorId(@PathVariable Long id) {
        return converter(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrechoDTO cadastrar(@Valid @RequestBody TrechoDTO dto) {
        return converter(service.cadastrar(converter(dto)));
    }

    @PutMapping("/{id}")
    public TrechoDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody TrechoDTO dto) {
        return converter(service.atualizar(id, converter(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

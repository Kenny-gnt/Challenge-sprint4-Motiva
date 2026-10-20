package br.com.motiva.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.motiva.model.IntervencaoOperacional;
import br.com.motiva.repository.IntervencaoOperacionalRepository;

@Service
public class IntervencaoOperacionalService {

    private final IntervencaoOperacionalRepository repository;

    public IntervencaoOperacionalService(
            IntervencaoOperacionalRepository repository) {
        this.repository = repository;
    }

    public List<IntervencaoOperacional> listarTodos() {
        return repository.findAll();
    }

    public IntervencaoOperacional buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Intervenção não encontrada: " + id));
    }

    public IntervencaoOperacional cadastrar(
            IntervencaoOperacional intervencao) {
        return repository.save(intervencao);
    }

    public IntervencaoOperacional atualizar(
            Long id, IntervencaoOperacional dados) {
        IntervencaoOperacional intervencao = buscarPorId(id);
        intervencao.setTipo(dados.getTipo());
        intervencao.setEquipeResponsavel(dados.getEquipeResponsavel());
        return repository.save(intervencao);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
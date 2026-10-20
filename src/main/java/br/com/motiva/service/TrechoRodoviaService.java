package br.com.motiva.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.motiva.model.TrechoRodovia;
import br.com.motiva.repository.TrechoRodoviaRepository;

@Service
public class TrechoRodoviaService {

    private final TrechoRodoviaRepository repository;

    public TrechoRodoviaService(TrechoRodoviaRepository repository) {
        this.repository = repository;
    }

    public List<TrechoRodovia> listarTodos() {
        return repository.findAll();
    }

    public TrechoRodovia buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Trecho não encontrado: " + id));
    }

    public List<TrechoRodovia> buscarPorTipo(String tipo) {
        return repository.findByTipo(tipo.toUpperCase());
    }

    public List<TrechoRodovia> buscarPorNivelVegetacao(Double minimo) {
        return repository.findByNivelVegetacaoGreaterThanEqual(minimo);
    }

    public TrechoRodovia cadastrar(TrechoRodovia trecho) {
        return repository.save(trecho);
    }

    public TrechoRodovia atualizar(Long id, TrechoRodovia dados) {
        TrechoRodovia trecho = buscarPorId(id);

        trecho.setKm(dados.getKm());
        trecho.setNivelVegetacao(dados.getNivelVegetacao());
        trecho.setTipo(dados.getTipo());

        return repository.save(trecho);
    }

    public void excluir(Long id) {
        TrechoRodovia trecho = buscarPorId(id);
        repository.delete(trecho);
    }
}

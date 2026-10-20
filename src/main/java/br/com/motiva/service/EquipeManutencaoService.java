package br.com.motiva.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.motiva.model.EquipeManutencao;
import br.com.motiva.repository.EquipeManutencaoRepository;

@Service
public class EquipeManutencaoService {

    private final EquipeManutencaoRepository repository;

    public EquipeManutencaoService(EquipeManutencaoRepository repository) {
        this.repository = repository;
    }

    public List<EquipeManutencao> listarTodos() {
        return repository.findAll();
    }

    public EquipeManutencao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada: " + id));
    }

    public EquipeManutencao cadastrar(EquipeManutencao equipe) {
        return repository.save(equipe);
    }

    public EquipeManutencao atualizar(Long id, EquipeManutencao dados) {
        EquipeManutencao equipe = buscarPorId(id);
        equipe.setNomeEquipe(dados.getNomeEquipe());
        equipe.setQuantidadeFuncionarios(dados.getQuantidadeFuncionarios());
        return repository.save(equipe);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
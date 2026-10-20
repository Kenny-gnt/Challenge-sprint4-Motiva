package br.com.motiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.motiva.model.EquipeManutencao;

public interface EquipeManutencaoRepository extends JpaRepository<EquipeManutencao, Long> {
}
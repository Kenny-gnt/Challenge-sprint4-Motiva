package br.com.motiva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.motiva.model.TrechoRodovia;

public interface TrechoRodoviaRepository extends JpaRepository<TrechoRodovia, Long> {

    List<TrechoRodovia> findByNivelVegetacaoGreaterThanEqual(Double minimo);

    List<TrechoRodovia> findByTipo(String tipo);
}
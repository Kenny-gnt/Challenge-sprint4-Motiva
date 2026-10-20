package br.com.motiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.motiva.model.IntervencaoOperacional;

public interface IntervencaoOperacionalRepository
        extends JpaRepository<IntervencaoOperacional, Long> {
}
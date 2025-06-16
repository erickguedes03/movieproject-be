package com.movieproject.MovieProject.repository;

import com.movieproject.MovieProject.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByFilmeId(Long filmeId);
}

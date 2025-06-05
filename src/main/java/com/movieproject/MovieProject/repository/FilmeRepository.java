package com.movieproject.MovieProject.repository;

import com.movieproject.MovieProject.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByGeneroContainingIgnoreCase(String genero);
    List<Filme> findByTituloContainingIgnoreCase(String titulo);
}

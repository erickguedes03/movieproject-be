package com.movieproject.MovieProject.repository;

import com.movieproject.MovieProject.model.Favorito;
import com.movieproject.MovieProject.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    List<Favorito> findByUsuario(String usuario);
    Optional<Favorito> findByUsuarioAndFilme(String usuario, Filme filme);
}

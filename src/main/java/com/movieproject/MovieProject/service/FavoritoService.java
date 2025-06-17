package com.movieproject.MovieProject.service;

import com.movieproject.MovieProject.model.Favorito;
import com.movieproject.MovieProject.model.Filme;
import com.movieproject.MovieProject.repository.FavoritoRepository;
import com.movieproject.MovieProject.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public Favorito marcarFavorito(String usuario, Long filmeId) {
        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        return favoritoRepository.findByUsuarioAndFilme(usuario, filme)
                .orElseGet(() -> favoritoRepository.save(new Favorito(null, usuario, filme)));
    }


    public void desmarcarFavorito(String usuario, Long filmeId) {
        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        favoritoRepository.findByUsuarioAndFilme(usuario, filme).ifPresent(favoritoRepository::delete);
    }

    public List<Filme> listarFavoritos(String usuario){
        return favoritoRepository.findByUsuario(usuario).stream()
                .map(Favorito::getFilme)
                .collect(Collectors.toList());
    }
}

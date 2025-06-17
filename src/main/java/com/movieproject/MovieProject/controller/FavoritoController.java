package com.movieproject.MovieProject.controller;

import com.movieproject.MovieProject.model.Favorito;
import com.movieproject.MovieProject.model.Filme;
import com.movieproject.MovieProject.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @PostMapping("/{usuarioId}/{filmeId}")
    public ResponseEntity<Favorito> marcarFavorito(@PathVariable String usuarioId, @PathVariable Long filmeId) {
        Favorito favorito = favoritoService.marcarFavorito(usuarioId, filmeId);
        return ResponseEntity.status(HttpStatus.CREATED).body(favorito);
    }

    @DeleteMapping("/{usuario}/{filmeId}")
    public ResponseEntity<?> desmarcarFavorito(@PathVariable String usuario, @PathVariable Long filmeId) {
        favoritoService.desmarcarFavorito(usuario, filmeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{usuario}")
    public List<Filme> listarFavoritos(@PathVariable String usuario){
        return favoritoService.listarFavoritos(usuario);
    }
}

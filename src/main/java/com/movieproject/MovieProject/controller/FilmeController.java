package com.movieproject.MovieProject.controller;

import com.movieproject.MovieProject.model.Favorito;
import com.movieproject.MovieProject.model.Filme;
import com.movieproject.MovieProject.repository.FilmeRepository;
import com.movieproject.MovieProject.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;
    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> listarTodos(){
        return filmeService.listarTodos();
    }

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id){
        return filmeService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/genero/{genero}")
    public List<Filme> filrarPorGenero(@PathVariable String genero){
        return filmeService.filtrarPorGenero(genero);
    }

    @GetMapping("/buscar/{titulo}")
    public List<Filme> buscarPorTitulo(@PathVariable String titulo) {
        return filmeService.buscarPorTitulo(titulo);
    }

    @PatchMapping("/{id}/favorito")
    public ResponseEntity<Void> marcarComoFavorito(@PathVariable Long id, @RequestParam boolean favorito){
        Optional<Filme> filmeOpt = filmeRepository.findById(id);
        if (filmeOpt.isPresent()) {
            Filme filme = filmeOpt.get();
            filme.setFavorito(favorito);
            filmeRepository.save(filme);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

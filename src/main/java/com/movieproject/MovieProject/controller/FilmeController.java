package com.movieproject.MovieProject.controller;

import com.movieproject.MovieProject.model.Filme;
import com.movieproject.MovieProject.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> listarTodos(){
        return filmeService.listarTodos();
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


}

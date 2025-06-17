package com.movieproject.MovieProject.controller;

import com.movieproject.MovieProject.model.Avaliacao;
import com.movieproject.MovieProject.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping("/{filmeId}")
    public ResponseEntity<Avaliacao> cadastrar(@PathVariable Long filmeId, @RequestBody @Valid Avaliacao avaliacao) {
        Avaliacao salva = avaliacaoService.cadastrarAvaliacao(filmeId, avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping("/{filmeId}")
    public List<Avaliacao> listarPorFilme(@PathVariable Long filmeId) {
        return avaliacaoService.listarAvaliacoesPorFilme(filmeId);
    }
}

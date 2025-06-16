package com.movieproject.MovieProject.controller;

import com.movieproject.MovieProject.model.Avaliacao;
import com.movieproject.MovieProject.repository.AvaliacaoRepository;
import com.movieproject.MovieProject.repository.FilmeRepository;
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
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @PostMapping("/{filmeId}")
    public ResponseEntity<Avaliacao> cadastrar(@PathVariable Long filmeId, @RequestBody @Valid Avaliacao avaliacao) {
        return filmeRepository.findById(filmeId).map(filme -> {
            avaliacao.setFilme(filme);
            Avaliacao salva = avaliacaoRepository.save(avaliacao);
            return ResponseEntity.status(HttpStatus.CREATED).body(salva);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/{filmeId}")
    public List<Avaliacao> listarPorFilme(@PathVariable Long filmeId){
        return avaliacaoRepository.findByFilmeId(filmeId);
    }
}

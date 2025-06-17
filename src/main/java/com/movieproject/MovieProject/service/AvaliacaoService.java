package com.movieproject.MovieProject.service;

import com.movieproject.MovieProject.model.Avaliacao;
import com.movieproject.MovieProject.model.Filme;
import com.movieproject.MovieProject.repository.AvaliacaoRepository;
import com.movieproject.MovieProject.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public Avaliacao cadastrarAvaliacao(Long filmeId, Avaliacao avaliacao) {
        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado com ID: " + filmeId));

        avaliacao.setFilme(filme);
        Avaliacao salva = avaliacaoRepository.save(avaliacao);

        atualizarNotaMedia(filme);
        return salva;
    }

    public List<Avaliacao> listarAvaliacoesPorFilme(Long filmeId) {
        return avaliacaoRepository.findByFilmeId(filmeId);
    }

    private void atualizarNotaMedia(Filme filme) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByFilmeId(filme.getId());
        double media = avaliacoes.stream().mapToInt(Avaliacao::getNota).average().orElse(0.0);

        filme.setNotaMedia(media);
        filmeRepository.save(filme);
    }
}

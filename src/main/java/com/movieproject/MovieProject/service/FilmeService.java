package com.movieproject.MovieProject.service;

import com.movieproject.MovieProject.model.Filme;
import com.movieproject.MovieProject.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> buscarPorId(Long id) {
        return filmeRepository.findById(id);
    }

    public List<Filme> filtrarPorGenero(String genero) {
        return filmeRepository.findByGeneroContainingIgnoreCase(genero);
    }

    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    public List<Filme> buscarPorTitulo(String titulo) {
        return filmeRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public void deletar(Long id) {
        if (!filmeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme com ID " + id + " não encontrado.");
        }
        filmeRepository.deleteById(id);
    }
}

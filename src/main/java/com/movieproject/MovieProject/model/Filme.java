package com.movieproject.MovieProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String sinopse;
    private Integer anoLancamento;
    private String genero;
    private String imagemUrl;
    private Double notaMedia;

    @Column(nullable = false)
    private boolean favorito = false;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}

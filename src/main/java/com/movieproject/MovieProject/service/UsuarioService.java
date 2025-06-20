package com.movieproject.MovieProject.service;

import com.movieproject.MovieProject.model.Usuario;
import com.movieproject.MovieProject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Usuario registrar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> autenticar(String email, String senha) {
        return usuarioRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(senha, user.getSenha()));
    }
}

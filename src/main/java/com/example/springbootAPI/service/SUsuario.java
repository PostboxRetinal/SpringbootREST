package com.example.springbootAPI.service;

import com.example.springbootAPI.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface SUsuario {
    String crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Optional<Usuario> usuarioPorId(int usuarioid);
    String actualizarUsuarioPorId(Usuario usuario);
}
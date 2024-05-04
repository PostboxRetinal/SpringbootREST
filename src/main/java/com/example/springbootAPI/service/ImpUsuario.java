package com.example.springbootAPI.service;

import com.example.springbootAPI.model.Usuario;
import com.example.springbootAPI.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary

public class ImpUsuario implements SUsuario{
    @Autowired
    IUsuario usuarioRepository;

    @Override
    public String crearUsuario(Usuario usuario){
        this.usuarioRepository.save(usuario);
        return "Tutor " + usuario.getNombre() + " creado";
    }

    @Override
    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> usuarioPorId(int usuarioid){
        return this.usuarioRepository.findById(usuarioid);
    }

    @Override
    public String actualizarUsuarioPorId(Usuario usuario){
        this.usuarioRepository.save(usuario);
        return "Usuario " + usuario.getNombre() + " actualizado";
    }
}
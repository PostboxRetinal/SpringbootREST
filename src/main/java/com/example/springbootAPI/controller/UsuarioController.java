package com.example.springbootAPI.controller;

import com.example.springbootAPI.exception.FileNotFoundException;
import com.example.springbootAPI.exception.InvalidFieldsException;
import com.example.springbootAPI.model.Usuario;
import com.example.springbootAPI.service.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/springbootapi/usuario")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private SUsuario usuarioService;
    //OPERACIONES CRUD
    //CREATE
    @PostMapping("/")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.crearUsuario(usuario);
        return new ResponseEntity<String>(usuarioService.crearUsuario(usuario), HttpStatus.OK);
    }
    //READ
    @GetMapping("/")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    //READ2
    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable Integer usuarioId) {
        Usuario usuario = this.usuarioService.usuarioPorId(usuarioId)
                .orElseThrow(() -> new FileNotFoundException("ERROR: No se encontró el usuario con el id " + usuarioId));
        return ResponseEntity.ok(usuario);
    }

    //UPDATE
    @PutMapping("/{usuarioId}")
    public ResponseEntity<String> actualizarUsuarioPorId(@PathVariable Integer usuarioId, @RequestBody Usuario usuarioData) {
        Usuario usuario = this.usuarioService.usuarioPorId(usuarioId)
                .orElseThrow(() -> new FileNotFoundException("ERROR: No se encontró el usuario con el id " + usuarioId));
        String actualizarNombre = usuarioData.getNombre();
        String actualizarCarrera = usuarioData.getCarrera();

        if (actualizarNombre != null && !actualizarNombre.isEmpty() && actualizarCarrera != null && !actualizarCarrera.isEmpty()) {
            usuario.setNombre(actualizarNombre);
            usuario.setCarrera(actualizarCarrera);
            return new ResponseEntity<String>(usuarioService.actualizarUsuarioPorId(usuario), HttpStatus.OK);
        } else {
            throw new InvalidFieldsException("ERROR: Campo de contenido inválido. Por favor, ingresa un valor válido");
        }
    }
}
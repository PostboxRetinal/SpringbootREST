package com.example.springbootAPI.service;

import com.example.springbootAPI.model.Curso;

import java.util.List;
import java.util.Optional;

public interface SCurso {

    String crearCurso(Curso curso);
    List<Curso> listarCursos();
    Optional<Curso> cursoPorId(int cursoid);
    String actualizarCursoPorId(Curso curso);
    List<Curso> mostrarCursosPorCalificacionMayoresAN(double calificacion);
}
package com.example.springbootAPI.service;

import com.example.springbootAPI.model.Tutor;

import java.util.List;
import java.util.Optional;

public interface STutor {
    String crearTutor(Tutor tutor);
    List<Tutor> listarTutores();
    Optional<Tutor> tutorPorId(int tutorid);
    String actualizarTutorPorId(Tutor tutor);
    List<Tutor> mostrarCalificacionesMayoresAN(double calificacion);
}
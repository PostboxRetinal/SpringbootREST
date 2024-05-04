package com.example.springbootAPI.service;

import com.example.springbootAPI.model.Calificacion;

import java.util.List;
import java.util.Optional;

public interface SCalificacion {
    String crearCalificacion(Calificacion calificacion);
    List<Calificacion> listarCalificaciones();
    Optional<Calificacion> calificacionPorId(int calificacionid);
    String actualizarCalPorId(Calificacion calificacion);
}

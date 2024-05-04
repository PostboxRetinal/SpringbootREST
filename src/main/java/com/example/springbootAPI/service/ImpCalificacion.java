package com.example.springbootAPI.service;

import com.example.springbootAPI.model.Calificacion;
import com.example.springbootAPI.repository.ICalificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary

public class ImpCalificacion implements SCalificacion{
    @Autowired
    ICalificacion calificacionRepository;

    @Override
    public String crearCalificacion(Calificacion calificacion){
        this.calificacionRepository.save(calificacion);
        return "Calificacion creado";
    }

    @Override
    public List<Calificacion> listarCalificaciones(){
        return this.calificacionRepository.findAll();
    }

    @Override
    public Optional<Calificacion> calificacionPorId(int calificacionid){
        return this.calificacionRepository.findById(calificacionid);
    }

    @Override
    public String actualizarCalPorId(Calificacion calificacion){
        this.calificacionRepository.save(calificacion);
        return "Calificacion actualizado";
    }
}
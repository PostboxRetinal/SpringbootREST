package com.example.springbootAPI.service;

import com.example.springbootAPI.model.Tutor;
import com.example.springbootAPI.repository.ITutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary

public class ImpTutor implements STutor{
    @Autowired
    ITutor tutorRepository;

    @Override
    public String crearTutor(Tutor tutor){
        this.tutorRepository.save(tutor);
        return "Tutor " + tutor.getNombre() + " creado";
    }

    @Override
    public List<Tutor> listarTutores(){
        return this.tutorRepository.findAll();
    }

    @Override
    public Optional<Tutor> tutorPorId(int tutorid){
        return this.tutorRepository.findById(tutorid);
    }

    @Override
    public String actualizarTutorPorId(Tutor tutor){
        this.tutorRepository.save(tutor);
        return "Tutor " + tutor.getNombre() + " actualizado";
    }

    @Override
    public List<Tutor> mostrarCalificacionesMayoresAN(double calificacion){
        return this.tutorRepository.listarCalificacionesMayoresAN(calificacion);
    }
}
package com.example.springbootAPI.service;

import com.example.springbootAPI.model.Curso;
import com.example.springbootAPI.repository.ICurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary

public class ImpCurso implements SCurso{
    @Autowired
    ICurso cursoRepository;

    @Override
    public String crearCurso(Curso curso){
        this.cursoRepository.save(curso);
        return "Curso " + curso.getNombre() + " creado";
    }

    @Override
    public List<Curso> listarCursos(){
        return this.cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> cursoPorId(int cursoid){
        return this.cursoRepository.findById(cursoid);
    }

    @Override
    public String actualizarCursoPorId(Curso curso){
        this.cursoRepository.save(curso);
        return "Curso " + curso.getNombre() + " actualizado";
    }

    @Override
    public List<Curso> mostrarCursosPorCalificacionMayoresAN(double calificacion){
        return this.cursoRepository.listarCursosCalificacionesMayoresAN(calificacion);
    }
}
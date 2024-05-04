package com.example.springbootAPI.repository;

import com.example.springbootAPI.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICurso extends MongoRepository<Curso, Integer> {
    List<Curso> listarCalificacionesMayoresAN(Double calificacion);
}

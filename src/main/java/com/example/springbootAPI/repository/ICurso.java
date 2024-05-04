package com.example.springbootAPI.repository;

import com.example.springbootAPI.model.Curso;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICurso extends MongoRepository<Curso, Integer>{
    @Aggregation({
            "{'$lookup': { 'from': 'Calificaciones', 'localField': '_id', 'foreignField': 'cursoid', 'as': 'Calificaciones' } }",
            "{'$unwind': '$Calificaciones' }",
            "{'$match': { 'Calificaciones.calificacion': { '$gte': ?0 } } }"})
    List<Curso> listarCursosCalificacionesMayoresAN(Double calificacion);
}
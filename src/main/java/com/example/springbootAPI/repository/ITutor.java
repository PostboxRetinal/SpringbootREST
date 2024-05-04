package com.example.springbootAPI.repository;

import com.example.springbootAPI.model.Tutor;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITutor extends MongoRepository<Tutor, Integer> {
    @Aggregation({
            "{'$lookup': {'from': 'Cursos', 'localField': '_id', 'foreignField': 'tutorId', 'as': 'Cursos'}}",
            "{'$lookup': {'from': 'Calificaciones', 'localField': 'Cursos._id', 'foreignField': 'id_curso', 'as': 'Cursos.Calificaciones'}}",
            "{'$unwind': '$Cursos.Calificaciones'}",
            "{'$match': {'Cursos.Calificaciones.calificacion': {'$gte': ?0}}}",
            "{'$group': {'_id': {'_id': '$_id', 'nombre': '$nombre'}, 'Cursos': {'$push': '$Cursos'}}}",
            "{'$project': {'_id': '$_id._id', 'nombre': '$_id.nombre', 'tutor': 1, 'Cursos': 1}}"})
    List<Tutor> listarCalificacionesMayoresAN(Double calificacion);
}
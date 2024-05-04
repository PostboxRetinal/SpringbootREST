package com.example.springbootAPI.repository;

import com.example.springbootAPI.model.Calificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICalificacion extends MongoRepository<Calificacion, Integer> {
}

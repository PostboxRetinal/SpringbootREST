package com.example.springbootAPI.repository;

import com.example.springbootAPI.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuario extends MongoRepository<Usuario, Integer> {
}
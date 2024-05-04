package com.example.springbootAPI.repository;

import com.example.springbootAPI.model.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITutor extends MongoRepository<Tutor, Integer> {
}

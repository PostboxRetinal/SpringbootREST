package com.example.springbootAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Curso {
    @Id
    private Integer id_curso;
    private String nombre;
    private String categoria;
    private Integer horas;
}
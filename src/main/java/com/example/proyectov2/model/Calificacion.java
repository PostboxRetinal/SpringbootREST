package com.example.proyectov2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Calificaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {
    @Id
    private Integer id_calificacion;
    private Integer id_curso;
    private Integer calificacion;

}

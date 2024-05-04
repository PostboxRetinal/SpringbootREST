package com.example.springbootAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tutores")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tutor {
    @Id
    private Integer id_tutor;
    private String nombre_tutor;
}

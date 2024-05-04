package com.example.springbootAPI.controller;

import com.example.springbootAPI.exception.FileNotFoundException;
import com.example.springbootAPI.model.Curso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CursoController {
    //Eliminar un Curso por Id
    @DeleteMapping("/{cursoId}")
    public ResponseEntity<String> eliminarCursoPorId(@PathVariable Integer cursoId) {
        Curso curso = this.cursoService.obtenerCursoPorId(cursoId)
                .orElseThrow(() -> new FileNotFoundException("Error! No se encontró el curso con el id " + cursoId));
        return new ResponseEntity<String>(cursoService.eliminarCursoPorId(cursoId),HttpStatus.OK);
    }
}
}

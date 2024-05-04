package com.example.springbootAPI.controller;

import com.example.springbootAPI.exception.FileNotFoundException;
import com.example.springbootAPI.exception.InvalidFieldsException;
import com.example.springbootAPI.model.Curso;
import com.example.springbootAPI.service.SCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/springbootapi/curso")
@CrossOrigin
public class CursoController {
    @Autowired
    private SCurso cursoService;
    //OPERACIONES CRUD
    //CREATE
    @PostMapping("/")
    public ResponseEntity<String> crearCurso(@RequestBody Curso curso) {
        cursoService.crearCurso(curso);
        return new ResponseEntity<String>(cursoService.crearCurso(curso), HttpStatus.OK);
    }

    //READ
    @GetMapping("/")
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.listarCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    //READ
    @GetMapping("/{cursoId}")
    public ResponseEntity<Curso> cursoPorId(@PathVariable Integer cursoId) {
        Curso curso = this.cursoService.cursoPorId(cursoId)
                .orElseThrow(() -> new FileNotFoundException("Error! No se encontró el curso con el id " + cursoId));
        return ResponseEntity.ok(curso);
    }

    //UPDATE
    @PutMapping("/{cursoId}")
    public ResponseEntity<String> actualizarCursoPorId(@PathVariable Integer cursoId, @RequestBody Curso cursoData) {
        Curso curso = this.cursoService.cursoPorId(cursoId)
                .orElseThrow(() -> new FileNotFoundException("Error!. No se encontró el curso con el id " + cursoId));
        String actualizarNombre = cursoData.getNombre();
        String actualizarCategoria = cursoData.getCategoria();

        if (actualizarNombre != null && !actualizarNombre.isEmpty() && actualizarCategoria != null && !actualizarCategoria.isEmpty()) {
            curso.setNombre(actualizarNombre);
            curso.setCategoria(actualizarCategoria);
            return new ResponseEntity<String>(cursoService.actualizarCursoPorId(curso), HttpStatus.OK);
        } else {
            throw new InvalidFieldsException("Error!");
        }
    }
    //Mostrar cursos por calificación
    @GetMapping("/calificacionCurso/{calificacion}")
    public ResponseEntity<List<Curso>> mostrarCursosPorCalificacionMayoresAN(@PathVariable Double calificacion) {
        List<Curso> cursos = cursoService.mostrarCursosPorCalificacionMayoresAN(calificacion);
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
}
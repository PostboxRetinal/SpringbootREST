package com.example.springbootAPI.controller;

import com.example.springbootAPI.exception.FileNotFoundException;
import com.example.springbootAPI.exception.InvalidFieldsException;
import com.example.springbootAPI.model.Tutor;
import com.example.springbootAPI.service.STutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/springbootapi/tutor")
@CrossOrigin
public class TutorController {
    @Autowired
    private STutor tutorService;
    //CRUD OPS
    //CREATE
    @PostMapping("/")
    public ResponseEntity<String> crearTutor(@RequestBody Tutor tutor) {
        tutorService.crearTutor(tutor);
        return new ResponseEntity<String>(tutorService.crearTutor(tutor), HttpStatus.OK);
    }
    //READ
    @GetMapping("/")
    public ResponseEntity<List<Tutor>> listarTutores() {
        List<Tutor> tutores = tutorService.listarTutores();
        return new ResponseEntity<>(tutores, HttpStatus.OK);
    }
    //READ
    @GetMapping("/{tutorId}")
    public ResponseEntity<Tutor> tutorPorId(@PathVariable Integer tutorId) {
        Tutor tutor = this.tutorService.tutorPorId(tutorId)
                .orElseThrow(() -> new FileNotFoundException("Error! No se encontró el tutor con el id " + tutorId));
        return ResponseEntity.ok(tutor);
    }

    //UPDATE
    @PutMapping("/{tutorId}")
    public ResponseEntity<String> actualizarTutorPorId(@PathVariable Integer tutorId, @RequestBody Tutor tutorData) {
        Tutor tutor = this.tutorService.tutorPorId(tutorId)
                .orElseThrow(() -> new FileNotFoundException("ERROR: No se encontró el tutor con el id " + tutorId));
        String actualizarNombre = tutorData.getNombre_tutor();

        if (actualizarNombre != null && !actualizarNombre.isEmpty()) {
            tutor.setNombre_tutor(actualizarNombre);
            return new ResponseEntity<String>(tutorService.actualizarTutorPorId(tutor), HttpStatus.OK);
        } else {
            throw new InvalidFieldsException("ERROR: Campo de contenido inválido. Por favor, ingresa un valor válido");
        }
    }
    //Mostrar tutores por calificación
    @GetMapping("/filtroCalificacion/{calificacion}")
    public ResponseEntity<List<Tutor>> mostrarTutoresCalificacionesMayoresAN(@PathVariable Double calificacion) {
        List<Tutor> tutores = tutorService.mostrarCalificacionesMayoresAN(calificacion);
        return new ResponseEntity<>(tutores, HttpStatus.OK);
    }

}
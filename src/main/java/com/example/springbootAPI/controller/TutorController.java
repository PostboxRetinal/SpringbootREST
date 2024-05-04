package com.example.springbootAPI.controller;

import com.example.springbootAPI.exception.InvalidFieldsException;
import com.example.springbootAPI.exception.FileNotFoundException;
import com.example.springbootAPI.model.Tutor;
import com.example.springbootAPI.service.STutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/springbootapi/tutor")
@CrossOrigin
public class TutorController {
    @Autowired
    private STutor tutorService;
    //OPERACIONES CRUD
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
    //READ2
    @GetMapping("/{tutorId}")
    public ResponseEntity<Tutor> tutorPorId(@PathVariable Integer tutorId) {
        Tutor tutor = this.tutorService.tutorPorId(tutorId)
                .orElseThrow(() -> new FileNotFoundException("ERROR: No se encontró el tutor con el id " + tutorId));
        return ResponseEntity.ok(tutor);
    }

    //UPDATE
    @PutMapping("/{tutorId}")
    public ResponseEntity<String> actualizarTutorPorId(@PathVariable Integer tutorId, @RequestBody Tutor tutorData) {
        Tutor tutor = this.tutorService.tutorPorId(tutorId)
                .orElseThrow(() -> new FileNotFoundException("ERROR: No se encontró el tutor con el id " + tutorId));
        String actualizarNombre = tutorData.getNombre();
        String actualizarFacultad = tutorData.getFacultad();

        if (actualizarNombre != null && !actualizarNombre.isEmpty() && actualizarFacultad != null && !actualizarFacultad.isEmpty()) {
            tutor.setNombre(actualizarNombre);
            tutor.setFacultad(actualizarFacultad);
            return new ResponseEntity<String>(tutorService.actualizarTutorPorId(tutor), HttpStatus.OK);
        } else {
            throw new InvalidFieldsException("Error: Por favor, ingrese un valor válido");
        }
    }

    @GetMapping("/TutorCursoCal/{calificacion}")
    public ResponseEntity<List<Tutor>> mostrarCalificacionesMayoresAN(@PathVariable Double calificacion) {
        List<Tutor> tutores = tutorService.mostrarCalificacionesMayoresAN(calificacion);
        return new ResponseEntity<>(tutores, HttpStatus.OK);
    }
}
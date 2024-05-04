package com.example.springbootAPI.controller;

import com.example.springbootAPI.exception.InvalidFieldsException;
import com.example.springbootAPI.exception.FileNotFoundException;
import com.example.springbootAPI.model.Calificacion;
import com.example.springbootAPI.model.Curso;
import com.example.springbootAPI.service.SCalificacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/springbootAPI/calificacion")
@CrossOrigin
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    //Crear un calificacion
    @PostMapping("/")
    public ResponseEntity<String> creaCalificacion(@RequestBody CalificacionModel calificacion) {
        calificacionService.crearCalificacion(calificacion);
        return new ResponseEntity<String>(calificacionService.crearCalificacion(calificacion), HttpStatus.OK);
    }
    //Listar calificaciones
    @GetMapping("/")
    public ResponseEntity<List<CalificacionModel>> listarCalificaciones() {
        List<CalificacionModel> calificaciones = calificacionService.listarCalificaciones();
        return new ResponseEntity<>(calificaciones, HttpStatus.OK);
    }
    //Consultar un calificacion por Id
    @GetMapping("/{calificacionId}")
    public ResponseEntity<CalificacionModel> calificacionPorId(@PathVariable Integer calificacionId) {
        CalificacionModel calificacion = this.calificacionService.calificacionPorId(calificacionId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Error! No se encontró el curso con el id " + calificacionId));
        return ResponseEntity.ok(calificacion);
    }
    //Actualizar la información básica del curso
    @PutMapping("/{calificacionId}")
    public ResponseEntity<String> actualizarCalificacionPorId(@PathVariable Integer calificacionId, @RequestBody CalificacionModel calificacionData) {
        CalificacionModel calificacion = this.calificacionService.calificacionPorId(calificacionId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Error!. No se encontró el calificacion con el id " + calificacionId));
        Double actualizarCalificacion = calificacionData.getCalificacion();

        if (actualizarCalificacion != null) {
            calificacion.setCalificacion(actualizarCalificacion);
            return new ResponseEntity<String>(calificacionService.actualizarCalPorId(calificacion), HttpStatus.OK);
        } else {
            throw new CamposInvalidosException("Error!");
        }
    }
}
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
@RequestMapping("/springbootapi/calificacion")
@CrossOrigin
public class CalificacionController {
    /**
     * Inyecto la dependencia de la clase SCalificacion
     */
    @Autowired
    private SCalificacion calificacionService;

    //Crear un calificacion
    @PostMapping("/")
    public ResponseEntity<String> creaCalificacion(@RequestBody Calificacion calificacion) {
        calificacionService.crearCalificacion(calificacion);
        return new ResponseEntity<String>(calificacionService.crearCalificacion(calificacion), HttpStatus.OK);
    }
    //Listar calificaciones
    @GetMapping("/")
    public ResponseEntity<List<Calificacion>> listarCalificaciones() {
        List<Calificacion> calificaciones = calificacionService.listarCalificaciones();
        return new ResponseEntity<>(calificaciones, HttpStatus.OK);
    }
    //Consultar un calificacion por Id
    @GetMapping("/{calificacionId}")
    public ResponseEntity<Calificacion> calificacionPorId(@PathVariable Integer calificacionId) {
        Calificacion calificacion = this.calificacionService.calificacionPorId(calificacionId)
                .orElseThrow(() -> new FileNotFoundException("ERROR: No se encontró la calificacion con el id " + calificacionId));
        return ResponseEntity.ok(calificacion);
    }
    //Actualizar la información básica del curso
    @PutMapping("/{calificacionId}")
    public ResponseEntity<String> actualizarCalificacionPorId(@PathVariable Integer calificacionId, @RequestBody Calificacion calificacionData) {
        Calificacion calificacion = this.calificacionService.calificacionPorId(calificacionId)
                .orElseThrow(() -> new FileNotFoundException("ERROR: No se encontró la calificacion con el id " + calificacionId));
        Double actualizarCalificacion = calificacionData.getCalificacion();

        if (actualizarCalificacion != null) {
            calificacion.setCalificacion(actualizarCalificacion);
            return new ResponseEntity<String>(calificacionService.actualizarCalPorId(calificacion), HttpStatus.OK);
        } else {
            throw new InvalidFieldsException("ERROR: Campo. Por favor, ingrese un valor válido");
        }
    }
}
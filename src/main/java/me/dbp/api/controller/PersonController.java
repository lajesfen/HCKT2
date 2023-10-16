package me.dbp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.dbp.api.entity.Alumno;
import me.dbp.api.repository.AlumnoRepository;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public ResponseEntity<List<Alumno>> alumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlumno(@PathVariable Long id) {

        if (!alumnoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno with ID " + id + " not found");
        }

        Alumno existingSong = alumnoRepository.findById(id).get();
        return new ResponseEntity<>(existingSong, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> alumno(@RequestBody Alumno alumno) {        
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {

        if (!alumnoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno with ID " + id + " not found");
        }
        
        alumno.setId(id);
        alumnoRepository.save(alumno);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable Long id) {

        if (!alumnoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno with ID " + id + " not found");
        }
        
        alumnoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
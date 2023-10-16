package me.dbp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.dbp.api.entity.Alumno;
import me.dbp.api.entity.Grade;
import me.dbp.api.repository.GradeRepository;
import me.dbp.api.repository.AlumnoRepository;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public ResponseEntity<List<Grade>> grades() {
        List<Grade> grades = gradeRepository.findAll();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    @GetMapping("/{x}")
    public ResponseEntity<?> getGrade(@PathVariable Long id) {

        if (!gradeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grade with ID " + id + " not found");
        }

        Grade existingGrade = gradeRepository.findById(id).get();
        return new ResponseEntity<>(existingGrade, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> grade(@RequestBody Grade grade) {
        gradeRepository.save(grade);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGrade(@PathVariable Long id, @RequestBody Grade grade) {

        if (!gradeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grade with ID " + id + " not found");
        }
        
        grade.setId(id);
        gradeRepository.save(grade);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGrade(@PathVariable Long id) {

        if (!gradeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grade with ID " + id + " not found");
        }
        
        gradeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @GetMapping("/alumno/{alumno_id}")
    public ResponseEntity<?> getGradeAlumno(@PathVariable Long alumno_id) {

        if (!alumnoRepository.existsById(alumno_id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno with ID " + alumno_id + " not found");
        }

        Alumno existingAlumno = gradeRepository.findByAlumno(alumno_id);
        return new ResponseEntity<>(existingAlumno.getGrades(), HttpStatus.OK);
    }
}
package me.dbp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.dbp.api.entity.Person;
import me.dbp.api.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personaRepository;

    @GetMapping
    public ResponseEntity<List<Person>> person() {
        List<Person> personas = personaRepository.findAll();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersona(@PathVariable Long id) {

        if (!personaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona with ID " + id + " not found");
        }

        Person existingPersona = personaRepository.findById(id).get();
        return new ResponseEntity<>(existingPersona, HttpStatus.OK);
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<?> getPersonaGroups(@PathVariable Long id) {

        if (!personaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona with ID " + id + " not found");
        }

        Person existingPersona = personaRepository.findById(id).get();
        return new ResponseEntity<>(existingPersona.getGroups(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> persona(@RequestBody Person persona) {  
        personaRepository.save(persona);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePersona(@PathVariable Long id, @RequestBody Person persona) {

        if (!personaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona with ID " + id + " not found");
        }
        
        persona.setId(id);
        personaRepository.save(persona);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id) {

        if (!personaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona with ID " + id + " not found");
        }
        
        personaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
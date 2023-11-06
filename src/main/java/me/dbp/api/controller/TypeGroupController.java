package me.dbp.api.controller;
import me.dbp.api.entity.Group;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.dbp.api.entity.TypeGroup;
import me.dbp.api.repository.TypeGroupRepository;

import java.lang.reflect.Type;
import java.security.PublicKey;
import java.util.List;


@RestController
@RequestMapping("/typeGroups")
public class TypeGroupController {
    @Autowired
    private TypeGroupRepository typeGroupRepository;
    
    @GetMapping
    public ResponseEntity<List<TypeGroup>> typeGroups(){
        List<TypeGroup> typeGroups = typeGroupRepository.findAll();
        return new ResponseEntity<>(typeGroups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTypeGroup(@PathVariable Long id){
        if(!typeGroupRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TypeGroup with ID " + id + " not found");
        }
        
        TypeGroup existingTypeGroup = typeGroupRepository.findById(id).get();
        return new ResponseEntity<>(existingTypeGroup, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> typeGroup(@RequestBody TypeGroup typeGroup) {
        typeGroupRepository.save(typeGroup);
        return ResponseEntity.status(201).body("Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup5(@PathVariable Long id) {
        if (!typeGroupRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group with ID " + id + " not found");
        }

        typeGroupRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}

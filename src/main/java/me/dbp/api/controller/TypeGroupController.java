package me.dbp.api.controller;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dbp.api.entity.TypeGroup;
import me.dbp.api.repository.TypeGroupRepository;

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
        
        TypeGroup exisTypeGroup = typeGroupRepository.findById(id).get();
    }

}

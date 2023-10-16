package me.dbp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.dbp.api.entity.Group;
import me.dbp.api.repository.GroupRepository;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public ResponseEntity<List<Group>> groups() {
        List<Group> groups = groupRepository.findAll();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroup(@PathVariable Long id) {

        if (!groupRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group with ID " + id + " not found");
        }

        Group existingGroup = groupRepository.findById(id).get();
        return new ResponseEntity<>(existingGroup, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<?> getGroupPerson(@PathVariable Long id) {

        if (!groupRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group with ID " + id + " not found");
        }

        Group existingGroup = groupRepository.findById(id).get();
        return new ResponseEntity<>(existingGroup.getPersons(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> group(@RequestBody Group group) {
        groupRepository.save(group);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGroup(@PathVariable Long id, @RequestBody Group group) {

        if (!groupRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group with ID " + id + " not found");
        }
        
        group.setId(id);
        groupRepository.save(group);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long id) {

        if (!groupRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group with ID " + id + " not found");
        }
        
        groupRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}

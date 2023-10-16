package me.dbp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dbp.api.entity.Person;

public interface PersonaRepository extends JpaRepository<Person, Long> {
    
}
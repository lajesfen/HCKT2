package me.dbp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dbp.api.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
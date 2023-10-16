package me.dbp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dbp.api.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
}
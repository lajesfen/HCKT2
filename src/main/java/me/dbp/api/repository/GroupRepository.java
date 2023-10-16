package me.dbp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dbp.api.entity.Alumno;
import me.dbp.api.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Alumno findByAlumno(Long id);
}
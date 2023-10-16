package me.dbp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dbp.api.entity.Group;

public interface GradeRepository extends JpaRepository<Group, Long> {
}
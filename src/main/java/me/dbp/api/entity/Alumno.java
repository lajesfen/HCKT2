package me.dbp.api.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;

    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "grade_alumno",
            joinColumns = {@JoinColumn(name = "grade_id")},
            inverseJoinColumns = {@JoinColumn(name = "alumno_id")}
    )
    private List<Grade> grades;

    public Alumno() {}

    public Long getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getLastName() {
        return this.lastName;
    }

    public List<Grade> getGrades() {
        return this.grades;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
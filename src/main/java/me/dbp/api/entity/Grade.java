package me.dbp.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long score;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "grade_alumno",
            joinColumns = {@JoinColumn(name = "grade_id")},
            inverseJoinColumns = {@JoinColumn(name = "alumno_id")}
    )
    private Alumno alumno;

    public Grade() {}

    public Long getId() {
        return this.id;
    }

    public Long getScore() {
        return this.score;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
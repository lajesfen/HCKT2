package me.dbp.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String name;

    private Long id;

    @ManyToMany
    private List<Person> persons;

    public Group() {}

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return this.id;
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
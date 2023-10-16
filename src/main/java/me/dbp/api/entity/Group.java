package me.dbp.api.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String name;

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
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
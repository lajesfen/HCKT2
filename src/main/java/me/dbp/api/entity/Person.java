package me.dbp.api.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToMany
    private List<Group> groups;

    public Person() {}

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
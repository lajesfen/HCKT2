package me.dbp.api.entity;

import jakarta.persistence.*;

import java.nio.file.attribute.GroupPrincipal;
import java.util.List;

@Entity
@Table(name = "tgroup")
public class TypeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "typegroup")
    private List<Group> groups;
    public TypeGroup(){}
    
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public List<Group> getGroups(){
        return this.groups;
    }
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGroups(List<Group> groups){
        this.groups = groups;
    }
}

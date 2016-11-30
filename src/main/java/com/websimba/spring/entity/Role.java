package com.websimba.spring.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "websimba")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<Users>();

    public Role() {
    }
    public Role(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Users> getUsers() {
        return users;
    }
    public void setUsers(Set<Users> users) {
        this.users = users;
    }

}

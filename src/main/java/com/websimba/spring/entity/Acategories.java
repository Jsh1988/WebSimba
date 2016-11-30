package com.websimba.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "acategories", schema = "websimba")
public class Acategories {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "alias")
    private String alias;
    @Basic
    @Column(name = "parent")
    private int parent;

    public Acategories(){

    }
    public Acategories(int id, String title, String alias, int parent) {
        super();
        this.id = id;
        this.title = title;
        this.alias = alias;
        this.parent = parent;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getParent() {
        return parent;
    }
    public void setParent(int parent) {
        this.parent = parent;
    }

}

package com.websimba.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "bxslider", schema = "websimba")
public class Bxslider {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "images")
    private String images;
    @Basic
    @Column(name = "url")
    private String url;

    public Bxslider() {
    }
    public Bxslider(int id, String title, String images, String url) {
        super();
        this.id = id;
        this.title = title;
        this.images = images;
        this.url = url;
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

    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}

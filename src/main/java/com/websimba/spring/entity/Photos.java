package com.websimba.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "photos", schema = "websimba")
public class Photos {
    @Id
    @Column(name = "id_photo")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idPhoto;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "photo")
    private String photo;
    @Basic
    @Column(name = "parent")
    private int parent;
    @Basic
    @Column(name = "photo_description")
    private String photoDescription;
    @Basic
    @Column(name = "link")
    private String link;
    @Basic
    @Column(name = "mark")
    private int mark;

    public Photos() {
    }

    public Photos(int idPhoto, String title, String photo, int parent, String photoDescription, String link, int mark) {
        super();
        this.idPhoto = idPhoto;
        this.title = title;
        this.photo = photo;
        this.parent = parent;
        this.photoDescription = photoDescription;
        this.link = link;
        this.mark = mark;
    }


    public int getIdPhoto() {
        return idPhoto;
    }
    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getParent() {
        return parent;
    }
    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }
    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

}

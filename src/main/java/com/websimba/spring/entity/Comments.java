package com.websimba.spring.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "comments", schema = "websimba")
public class Comments {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "parent")
    private int parent;
    @Basic
    @Column(name = "id_product")
    private int idProduct;
//    @Basic
//    @Column(name = "approved")
//    private byte approved;
    @Basic
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "is_admin")
    private byte isAdmin;
    @Transient
    private String strDate;

    public Comments() {
    }

    public Comments(int id, String firstname, String surname, String content, int parent, int idProduct, byte approved, Date date, byte isAdmin,String strDate) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.content = content;
        this.parent = parent;
        this.idProduct = idProduct;
//        this.approved = approved;
        this.date = date;
        this.isAdmin = isAdmin;
        this.strDate = strDate;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getParent() {
        return parent;
    }
    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

//    public byte getApproved() {
//        return approved;
//    }
//    public void setApproved(byte approved) {
//        this.approved = approved;
//    }

    //@Lob Сохраняет данные в BLOB или CLOB
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public byte getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getStrDate() {
        return strDate;
    }
    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

}

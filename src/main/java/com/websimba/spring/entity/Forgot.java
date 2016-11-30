package com.websimba.spring.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "forgot", schema = "websimba")
public class Forgot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "hash")
    private String hash;
    @Basic
    @Column(name = "expire")
    private int expire;
    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "{email.pattern.error}")
    @Basic
    @Column(name = "email")
    private String email;

    public Forgot() {
    }

    public Forgot(int id, String hash, int expire, String email) {
        super();
        this.id = id;
        this.hash = hash;
        this.expire = expire;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getExpire() {
        return expire;
    }
    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}

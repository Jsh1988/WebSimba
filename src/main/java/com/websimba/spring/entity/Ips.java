package com.websimba.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "ips", schema = "websimba")
public class Ips {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "ip_adress")
    private String ipAdress;

    public Ips() {
    }
    public Ips(int id, String ipAdress) {
        super();
        this.id = id;
        this.ipAdress = ipAdress;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIpAdress() {
        return ipAdress;
    }
    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

}

package com.websimba.spring.entity;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "visits", schema = "websimba")
public class Visits {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Temporal(value=TemporalType.DATE)
    @Column(name = "date")
    @Type(type="date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    @Basic
    @Column(name = "hosts")
    private int hosts;
    @Basic
    @Column(name = "views")
    private int views;
    @Transient
    private String strDate;

    public Visits() {
    }

    public Visits(int id, Date date, int hosts, int views,String strDate) {
        super();
        this.id = id;
        this.date = date;
        this.hosts = hosts;
        this.views = views;
        this.strDate = strDate;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int getHosts() {
        return hosts;
    }
    public void setHosts(int hosts) {
        this.hosts = hosts;
    }

    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }

    public String getStrDate() {
        return strDate;
    }
    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

}

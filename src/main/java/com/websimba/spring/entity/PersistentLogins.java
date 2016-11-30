package com.websimba.spring.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persistent_logins", schema = "websimba")
public class PersistentLogins {
    @Basic
    @Column(name = "username")
    private String username;
    @Id
    @Column(name = "series")
    private String series;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "last_used")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date lastUsed;

    public PersistentLogins() {
    }

    public PersistentLogins(String username, String series, String token, Date lastUsed) {
        super();
        this.username = username;
        this.series = series;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }


    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }


    public Date getLastUsed() {
        return lastUsed;
    }
    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

}

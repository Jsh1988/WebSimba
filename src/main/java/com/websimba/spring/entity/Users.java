package com.websimba.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users", schema = "websimba")
public class Users {

    @JsonProperty("Number")
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @JsonProperty("login")
    @NotNull
    @Size(min = 2,message = "{login.size.error}")
    @Basic
    @Column(name = "login")
    private String login;

    @JsonProperty("password")
    @NotNull
    @Size(min = 4,max = 32,message = "{password.size.error}")
    @Basic
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "{email.pattern.error}")
    @Basic
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Basic
    @Column(name = "firstname")
    private String firstname;

    @JsonIgnore
    @Basic
    @Column(name = "surname")
    private String surname;

    @JsonIgnore
    @Basic
    @Column(name = "phone")
    private Integer phone;

    @JsonIgnore
    @Basic
    @Column(name = "country")
    private String country;

    @JsonIgnore
    @Basic
    @Column(name = "region")
    private String region;

    @JsonIgnore
    @Basic
    @Column(name = "city")
    private String city;

    @JsonIgnore
    @Basic
    @Column(name = "indexs")
    private Integer indexs;

    @JsonIgnore
    @Basic
    @Column(name = "street")
    private String street;

    @JsonIgnore
    @Basic
    @Column(name = "house")
    private Integer house;

    @JsonIgnore
    @Basic
    @Column(name = "is_admin")
    private byte isAdmin;

    @JsonIgnore
    @Transient
    private boolean check;
    @JsonIgnore
    @Transient
    private String confirmPassword;
    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();

    public Users() {

    }

    public Users(int id, String login, String password, String email, String firstname, String surname, Integer phone, String country, String region, String city, Integer indexs, String street, Integer house, byte isAdmin, boolean check, String confirmPassword ) {
        super();
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.phone = phone;
        this.country = country;
        this.region = region;
        this.city = city;
        this.indexs = indexs;
        this.street = street;
        this.house = house;
        this.isAdmin = isAdmin;
        this.check = check;
        this.confirmPassword = confirmPassword;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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

    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Integer getIndexs() {
        return indexs;
    }
    public void setIndexs(Integer indexs) {
        this.indexs = indexs;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }
    public void setHouse(Integer house) {
        this.house = house;
    }

    public byte getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getCheck() {
        return check;
    }
    public void setCheck(boolean check) {
        this.check = check;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

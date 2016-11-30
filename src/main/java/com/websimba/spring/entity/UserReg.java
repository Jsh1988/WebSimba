package com.websimba.spring.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "users", schema = "websimba")
public class UserReg {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @NotNull
    @Size(min = 2,message = "{login.size.error}")
    @Basic
    @Column(name = "login")
    private String login;
    @NotNull
    @Size(min = 4,max = 32,message = "{password.size.error}")
    @Basic
    @Column(name = "password")
    private String password;
    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "{email.pattern.error}")
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "country")
    private String country;

    @Transient
    private boolean check;
    @Transient
    private String confirmPassword;
//    @ManyToMany
//    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

    public UserReg() {}
    public UserReg(int id, String login, String password, String email, String country, boolean check, String confirmPassword ) {
        super();
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.country = country;
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

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getCheck() {
        return check;
    }
    public void setCheck(boolean check) {
        this.check = check;
    }

////    public Set<Role> getRoles() {
////        return roles;
////    }
////    public void setRoles(Set<Role> roles) {
////        this.roles = roles;
////    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

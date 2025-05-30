package com.economiza.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", length = 35, nullable = false)
    private String first_name;
    @Column(name = "last_name", length = 35, nullable = false)
    private String last_name;
    @Column(name = "mail", length = 255, nullable = false)
    private String mail;
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    public AppUser() {
    }
    public AppUser(int id, String first_name, String last_name, String mail, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


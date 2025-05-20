package com.economiza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "currency", length = 3, nullable = false)
    private String currency;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser app_user_id;

    public Wallet() {
    }

    public Wallet(int id, String name, String currency, AppUser app_user_id) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.app_user_id = app_user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AppUser getApp_user_id() {
        return app_user_id;
    }

    public void setApp_user_id(AppUser app_user_id) {
        this.app_user_id = app_user_id;
    }
}

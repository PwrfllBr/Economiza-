package com.economiza.dtos;

import com.economiza.entities.AppUser;

public class WalletDTO {
    private int id;
    private String name;
    private String currency;
    private AppUser app_user_id;

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
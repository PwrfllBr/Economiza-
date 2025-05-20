package com.economiza.dtos;

import com.economiza.entities.AppUser;

public class TagDTO {
    private int id;
    private String name;
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

    public AppUser getApp_user_id() {
        return app_user_id;
    }

    public void setApp_user_id(AppUser app_user_id) {
        this.app_user_id = app_user_id;
    }
}
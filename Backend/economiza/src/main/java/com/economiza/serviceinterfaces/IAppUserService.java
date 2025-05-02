package com.economiza.serviceinterfaces;

import com.economiza.entities.AppUser;

import java.util.List;

public interface IAppUserService {
    public void insert(AppUser appUser);
    public List<AppUser> list();
    public void delete(int id);
    public AppUser listId(int id);
}

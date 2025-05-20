package com.economiza.serviceimplements;

import com.economiza.entities.AppUser;
import com.economiza.repositories.IAppUserRepository;
import com.economiza.serviceinterfaces.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImplement implements IAppUserService {
    @Autowired
    private IAppUserRepository auR;

    @Override
    public void insert(AppUser appUser) {
        auR.save(appUser);
    }

    @Override
    public List<AppUser> list() {
        return auR.findAll();
    }

    @Override
    public void delete(int id) {
        auR.deleteById(id);
    }

    @Override
    public AppUser listId(int id) {
        return auR.findById(id).orElse(new AppUser());
    }
}
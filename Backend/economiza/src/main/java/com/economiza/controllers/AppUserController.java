package com.economiza.controllers;

import com.economiza.dtos.NewUserDTO;
import com.economiza.entities.AppUser;
import com.economiza.serviceinterfaces.IAppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AppUserController {
    @Autowired
    private IAppUserService AUS;

    @PostMapping
    public void newUser(@RequestBody NewUserDTO nu){
        System.out.println("DEBUG: NewUserDTO received. first_name: " + nu.getFirst_name() + nu.getLast_name() + nu.getMail() + nu.getPassword());
        ModelMapper m = new ModelMapper();
        AppUser au = m.map(nu, AppUser.class);
        System.out.println("DEBUG: NewUserDTO received. first_name: " + au.getFirst_name() + au.getLast_name() + au.getMail() + au.getPassword());
        AUS.insert(au);
    }
}
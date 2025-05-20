package com.economiza.controllers;

import com.economiza.dtos.AppUserDTO;
import com.economiza.dtos.NewUserDTO;
import com.economiza.entities.AppUser;
import com.economiza.serviceinterfaces.IAppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class AppUserController {
    @Autowired
    private IAppUserService AUS;

    @PostMapping
    public void newUser(@RequestBody NewUserDTO nu){
        ModelMapper m = new ModelMapper();
        AppUser au = m.map(nu, AppUser.class);
        AUS.insert(au);
    }
    @PutMapping
    public void editUser(@RequestBody NewUserDTO nu){
        ModelMapper m = new ModelMapper();
        AppUser au = m.map(nu, AppUser.class);
        AUS.insert(au);
    }

    @GetMapping
    public List<AppUserDTO> listUsers(){
        return AUS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, AppUserDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AppUserDTO getUser(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        AppUserDTO dto = m.map(AUS.listId(id), AppUserDTO.class);
        return dto;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        AUS.delete(id);
    }
}
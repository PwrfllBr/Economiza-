package com.economiza.controllers;

import com.economiza.dtos.WalletDTO;
import com.economiza.entities.Wallet;
import com.economiza.serviceinterfaces.IWalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private IWalletService wS;
    @PostMapping
    private void addWallet(@RequestBody WalletDTO wd){
        ModelMapper m = new ModelMapper();
        Wallet w = m.map(wd, Wallet.class);
        wS.insert(w);
    }
    @PutMapping
    private void editWallet(@RequestBody WalletDTO wd){
        ModelMapper m = new ModelMapper();
        Wallet w = m.map(wd, Wallet.class);
        wS.insert(w);
    }
    @GetMapping
    public List<WalletDTO> listWallets(){
        return wS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, WalletDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public WalletDTO getWallet(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        WalletDTO dto = m.map(wS.listId(id), WalletDTO.class);
        return dto;
    }
    @GetMapping("/from/{id}")
    public List<WalletDTO> getWalletsFromUser(@PathVariable("id") Integer id){
        return wS.getUserWallets(id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, WalletDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void deleteWallet(@PathVariable("id") Integer id){
        wS.delete(id);
    }
}

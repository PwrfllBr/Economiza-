package com.economiza.controllers;

import com.economiza.dtos.TranxDTO;
import com.economiza.entities.Tranx;
import com.economiza.serviceinterfaces.ITranxService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tranx")
public class TranxController {
    @Autowired
    private ITranxService tS;
    @PostMapping
    public void addTranx(@RequestBody TranxDTO txd){
        ModelMapper m = new ModelMapper();
        Tranx t = m.map(txd, Tranx.class);
        tS.insert(t);
    }
    @PutMapping
    public void editTranx(@RequestBody TranxDTO txd){
        ModelMapper m = new ModelMapper();
        Tranx t = m.map(txd, Tranx.class);
        tS.insert(t);
    }
    @GetMapping("/{id}")
    public TranxDTO getTranx(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        TranxDTO dto = m.map(tS.listId(id), TranxDTO.class);
        return dto;
    }
    @GetMapping("/from/{id}")
    public List<TranxDTO> getTranxFromUser(@PathVariable("id") Integer id){
        return tS.getTranxFromUser(id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return  m.map(y, TranxDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/fromwallet/{id}")
    public List<TranxDTO> getTranxFromWallet(@PathVariable("id") Integer id){
        return tS.getTranxFromWallet(id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return  m.map(y, TranxDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void deleteTranx(@PathVariable("id") Integer id){
        tS.delete(id);
    }
}

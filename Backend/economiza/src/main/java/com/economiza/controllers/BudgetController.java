package com.economiza.controllers;

import com.economiza.dtos.BudgetDTO;
import com.economiza.entities.Budget;
import com.economiza.serviceinterfaces.IBudgetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    private IBudgetService bS;
    @PostMapping
    public void addBudget(@RequestBody BudgetDTO bud){
        ModelMapper m = new ModelMapper();
        Budget b = m.map(bud, Budget.class);
        bS.insert(b);
    }
    @PutMapping
    public void editBudget(@RequestBody BudgetDTO bud){
        ModelMapper m = new ModelMapper();
        Budget b = m.map(bud, Budget.class);
        bS.insert(b);
    }
    @GetMapping
    public List<BudgetDTO> listBudgets(){
        return  bS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, BudgetDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public BudgetDTO getBudget(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        BudgetDTO dto = m.map(bS.listId(id), BudgetDTO.class);
        return dto;
    }
    @DeleteMapping("/{id}")
    public void  deleteBudget(@PathVariable("id") Integer id){
        bS.delete(id);
    }
}

package com.economiza.serviceimplements;

import com.economiza.entities.Budget;
import com.economiza.repositories.IBudgetRepository;
import com.economiza.serviceinterfaces.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImplement implements IBudgetService {
    @Autowired
    private IBudgetRepository bR;
    @Override
    public void insert(Budget budget) {
        bR.save(budget);
    }

    @Override
    public List<Budget> list() {
        return bR.findAll();
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public Budget listId(int id) {
        return bR.findById(id).orElse(new Budget());
    }
}
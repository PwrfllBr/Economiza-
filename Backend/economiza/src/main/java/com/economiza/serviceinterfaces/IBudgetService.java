package com.economiza.serviceinterfaces;

import com.economiza.entities.Budget;

import java.util.List;

public interface IBudgetService {
    public void insert(Budget budget);
    public List<Budget> list();
    public void delete(int id);
    public Budget listId(int id);
}

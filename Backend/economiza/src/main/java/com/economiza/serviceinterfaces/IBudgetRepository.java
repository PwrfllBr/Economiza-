package com.economiza.serviceinterfaces;

import com.economiza.entities.Budget;

public interface IBudgetRepository {
    public void insert(Budget budget);
    public void delete(int id);
}

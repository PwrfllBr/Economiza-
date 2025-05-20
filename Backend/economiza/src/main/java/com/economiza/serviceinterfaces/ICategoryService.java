package com.economiza.serviceinterfaces;

import com.economiza.entities.Category;

import java.util.List;

public interface ICategoryService {
    public void insert (Category category);
    public List<Category> list();
    public void delete (int id);
    public Category listId (int id);
    public List<Category>  findByType(Boolean type);
}
package com.economiza.serviceimplements;

import com.economiza.entities.Category;
import com.economiza.repositories.ICategoryRepository;
import com.economiza.serviceinterfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImplement implements ICategoryService {
    @Autowired
    private ICategoryRepository cR;
    @Override
    public void insert(Category category) {
        cR.save(category);
    }

    @Override
    public List<Category> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public Category listId(int id) {
        return cR.findById(id).orElse(new Category());
    }
}

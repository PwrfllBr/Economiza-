package com.economiza.controllers;

import com.economiza.dtos.CategoryDTO;
import com.economiza.entities.Category;
import com.economiza.serviceinterfaces.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService cS;

    @PostMapping
    public void addCategory(@RequestBody CategoryDTO categoryDTO){
        ModelMapper m = new ModelMapper();
        Category c = m.map(categoryDTO, Category.class);
        cS.insert(c);
    }

    @PutMapping
    public void editCategory(@RequestBody CategoryDTO categoryDTO){
        ModelMapper m = new ModelMapper();
        Category c = m.map(categoryDTO, Category.class);
        cS.insert(c);
    }
    @GetMapping
    public List<CategoryDTO> listCategories(){
        return cS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, CategoryDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public CategoryDTO getCategory(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        CategoryDTO dto = m.map(cS.listId(id), CategoryDTO.class);
        return dto;
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Integer id){
        cS.delete(id);
    }
}

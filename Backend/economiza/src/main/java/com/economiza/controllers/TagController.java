package com.economiza.controllers;

import com.economiza.dtos.TagDTO;
import com.economiza.entities.Tag;
import com.economiza.serviceinterfaces.ITagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private ITagService tS;

    @PostMapping
    public void addTag(@RequestBody TagDTO tdto){
        ModelMapper m = new ModelMapper();
        Tag t = m.map(tdto, Tag.class);
        tS.insert(t);
    }
    @PutMapping
    public void editTag(@RequestBody TagDTO tdto){
        ModelMapper m = new ModelMapper();
        Tag t = m.map(tdto, Tag.class);
        tS.insert(t);
    }
    @GetMapping
    public List<TagDTO> listTags(){
        return tS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, TagDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public TagDTO getTag(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        TagDTO dto = m.map(tS.listId(id), TagDTO.class);
        return dto;
    }
    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable("id") Integer id){
        tS.delete(id);
    }
}
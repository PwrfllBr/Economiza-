package com.economiza.serviceimplements;

import com.economiza.entities.Tag;
import com.economiza.repositories.ITagRepository;
import com.economiza.serviceinterfaces.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImplement implements ITagService {
    @Autowired
    private ITagRepository tR;

    @Override
    public void insert(Tag tag) {
        tR.save(tag);
    }

    @Override
    public List<Tag> list() {
        return tR.findAll();
    }

    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }

    @Override
    public Tag listId(int id) {
        return tR.findById(id).orElse(new Tag());
    }
}

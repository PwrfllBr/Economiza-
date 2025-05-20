package com.economiza.serviceinterfaces;

import com.economiza.entities.Tag;

import java.util.List;

public interface ITagService {
    public void insert (Tag tag);
    public List<Tag> list();
    public void delete(int id);
    public Tag listId(int id);
}

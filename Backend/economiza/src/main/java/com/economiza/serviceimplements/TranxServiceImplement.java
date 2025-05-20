package com.economiza.serviceimplements;

import com.economiza.entities.Tranx;
import com.economiza.repositories.ITranxRepository;
import com.economiza.serviceinterfaces.ITranxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranxServiceImplement implements ITranxService {
    @Autowired
    private ITranxRepository txR;
    @Override
    public void insert(Tranx tranx) {
        txR.save(tranx);
    }

    @Override
    public List<Tranx> list() {
        return txR.findAll();
    }

    @Override
    public void delete(int id) {
        txR.deleteById(id);
    }

    @Override
    public Tranx listId(int id) {
        return txR.findById(id).orElse(new Tranx());
    }
}

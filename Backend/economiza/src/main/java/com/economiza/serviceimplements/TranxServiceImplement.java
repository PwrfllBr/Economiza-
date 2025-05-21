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
    public void delete(int id) {
        txR.deleteById(id);
    }

    @Override
    public Tranx listId(int id) {
        return txR.findById(id).orElse(new Tranx());
    }

    @Override
    public List<Tranx> getTranxFromUser(int id) {
        return txR.getTranxFromUser(id);
    }

    @Override
    public List<Tranx> getTranxFromWallet(int id) {
        return txR.getTranxFromWallet(id);
    }
}

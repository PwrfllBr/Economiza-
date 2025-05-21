package com.economiza.serviceinterfaces;

import com.economiza.entities.Tranx;

import java.util.List;

public interface ITranxService {
    public void insert(Tranx tranx);
    public void delete(int id);
    public Tranx listId(int id);
    public List<Tranx> getTranxFromUser(int id);
    public List<Tranx> getTranxFromWallet(int id);

}

package com.economiza.serviceinterfaces;

import com.economiza.entities.Wallet;

import java.util.List;

public interface IWalletService {
    public void insert (Wallet wallet);
    public void delete(int id);
    public Wallet listId(int id);
    public List<Wallet> getUserWallets(int id);
}

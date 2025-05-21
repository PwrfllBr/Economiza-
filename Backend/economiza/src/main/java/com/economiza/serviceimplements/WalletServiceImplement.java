package com.economiza.serviceimplements;

import com.economiza.entities.Wallet;
import com.economiza.repositories.IWalletRepository;
import com.economiza.serviceinterfaces.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImplement implements IWalletService {
    @Autowired
    private IWalletRepository wR;

    @Override
    public void insert(Wallet wallet) {
        wR.save(wallet);
    }

    @Override
    public List<Wallet> list() {
        return wR.findAll();
    }

    @Override
    public void delete(int id) {
        wR.deleteById(id);
    }

    @Override
    public Wallet listId(int id) {
        return wR.findById(id).orElse(new Wallet());
    }

    @Override
    public List<Wallet> getUserWallets(int id) {
        return wR.findWalletsFromUser(id);
    }
}

package com.economiza.repositories;

import com.economiza.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWalletRepository extends JpaRepository<Wallet, Integer> {
}

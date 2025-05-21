package com.economiza.repositories;

import com.economiza.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWalletRepository extends JpaRepository<Wallet, Integer> {
    @Query(value = "SELECT * FROM wallet\n" +
            "WHERE app_user_id = :id", nativeQuery = true)
    List<Wallet> findWalletsFromUser(@Param("id")int id);
}
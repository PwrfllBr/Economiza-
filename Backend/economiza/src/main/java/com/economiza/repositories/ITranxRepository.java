package com.economiza.repositories;

import com.economiza.entities.Tranx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITranxRepository extends JpaRepository<Tranx, Integer> {
    @Query(value = "SELECT t.id, t.amount, t.note, t.trx_date, t.category_id, t.tag_id, w.id as wallet_id\n" +
            "FROM tranx t\n" +
            "JOIN wallet w ON t.wallet_id = w.id\n" +
            "WHERE w.app_user_id = 2", nativeQuery = true)
    public List<Tranx> getTranxFromUser(@Param("id") int id);

    @Query(value = "SELECT * FROM tranx t\n" +
            "WHERE t.wallet_id = :id", nativeQuery = true)
    public List<Tranx> getTranxFromWallet(@Param("id") int id);
}

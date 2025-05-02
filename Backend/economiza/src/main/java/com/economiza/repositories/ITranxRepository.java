package com.economiza.repositories;

import com.economiza.entities.Tranx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITranxRepository extends JpaRepository<Tranx, Integer> {
}

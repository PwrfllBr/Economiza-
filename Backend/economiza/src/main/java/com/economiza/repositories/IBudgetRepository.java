package com.economiza.repositories;

import com.economiza.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBudgetRepository extends JpaRepository<Budget, Integer> {
}

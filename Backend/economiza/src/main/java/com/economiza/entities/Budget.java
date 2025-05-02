package com.economiza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;
    @Column(name = "initial_date", nullable = false)
    private LocalDate initial_date;
    @Column(name = "end_date", nullable = false)
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;
}

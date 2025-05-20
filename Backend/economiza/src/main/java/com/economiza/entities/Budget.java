package com.economiza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    public Budget() {
    }
    public Budget(int id, BigDecimal amount, LocalDate initial_date, LocalDate end_date, Wallet wallet_id, Category category_id) {
        this.id = id;
        this.amount = amount;
        this.initial_date = initial_date;
        this.end_date = end_date;
        this.wallet_id = wallet_id;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(LocalDate initial_date) {
        this.initial_date = initial_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Wallet getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(Wallet wallet_id) {
        this.wallet_id = wallet_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}

package com.economiza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tranx")
public class Tranx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;
    @Column(name = "trx_date", nullable = false)
    private LocalDate trx_date;
    @Column(name = "note", length = 255, nullable = false)
    private String note;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag_id;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet_id;

    public Tranx() {
    }

    public Tranx(int id, BigDecimal amount, LocalDate trx_date, String note, Category category_id, Tag tag_id, Wallet wallet_id) {
        this.id = id;
        this.amount = amount;
        this.trx_date = trx_date;
        this.note = note;
        this.category_id = category_id;
        this.tag_id = tag_id;
        this.wallet_id = wallet_id;
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

    public LocalDate getTrx_date() {
        return trx_date;
    }

    public void setTrx_date(LocalDate trx_date) {
        this.trx_date = trx_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public Tag getTag_id() {
        return tag_id;
    }

    public void setTag_id(Tag tag_id) {
        this.tag_id = tag_id;
    }

    public Wallet getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(Wallet wallet_id) {
        this.wallet_id = wallet_id;
    }
}

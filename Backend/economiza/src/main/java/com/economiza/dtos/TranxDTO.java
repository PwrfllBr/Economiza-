package com.economiza.dtos;

import com.economiza.entities.Category;
import com.economiza.entities.Tag;
import com.economiza.entities.Wallet;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TranxDTO {
    private int id;
    private BigDecimal amount;
    private LocalDate trx_date;
    private String note;
    private Category category_id;
    private Tag tag_id;
    private Wallet wallet_id;

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

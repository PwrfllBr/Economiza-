package com.economiza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
}

package com.economiza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", length = 35, nullable = false)
    private String first_name;
    @Column(name = "last_name", length = 35, nullable = false)
    private String last_name;
    @Column(name = "mail", length = 255, nullable = false)
    private String mail;
    @Column(name = "password", length = 100, nullable = false)
    private String password;
}

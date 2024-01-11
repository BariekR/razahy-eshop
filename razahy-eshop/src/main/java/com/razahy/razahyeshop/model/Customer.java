package com.razahy.razahyeshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    public Customer() {
    }

    public Customer(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

package com.razahy.razahyeshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getCategoryName() {
        if (category == null || category.getName() == null) {
            return "n/a";
        }
        return category.getName();
    }
}

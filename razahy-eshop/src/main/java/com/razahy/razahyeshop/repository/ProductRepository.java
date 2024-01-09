package com.razahy.razahyeshop.repository;

import com.razahy.razahyeshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

package com.razahy.razahyeshop.repository;

import com.razahy.razahyeshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

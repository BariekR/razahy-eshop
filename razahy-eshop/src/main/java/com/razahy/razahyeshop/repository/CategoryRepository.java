package com.razahy.razahyeshop.repository;

import com.razahy.razahyeshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

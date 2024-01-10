package com.razahy.razahyeshop.service;

import com.razahy.razahyeshop.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category saveCategory(Category category);
    List<Category> saveCategories(List<Category> categories);
}

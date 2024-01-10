package com.razahy.razahyeshop.service;

import com.razahy.razahyeshop.model.Category;
import com.razahy.razahyeshop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceDb implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> saveCategories(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }
}

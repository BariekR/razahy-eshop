package com.razahy.razahyeshop.initial;

import com.razahy.razahyeshop.model.Category;
import com.razahy.razahyeshop.model.Product;
import com.razahy.razahyeshop.utils.RandomUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryFactory {
    public List<Category> createCategories(int numberOfCategories) {
        List<Category> categories = new ArrayList<>(numberOfCategories);
        for (int i = 1; i <= numberOfCategories; i++) {
            categories.add(new Category(String.format("Category %d", i)));
        }
        return categories;
    }
}

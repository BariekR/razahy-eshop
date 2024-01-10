package com.razahy.razahyeshop.initial;

import com.razahy.razahyeshop.model.Category;
import com.razahy.razahyeshop.model.Product;
import com.razahy.razahyeshop.service.CategoryService;
import com.razahy.razahyeshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private ProductFactory productFactory;
    private ProductService productService;
    private CategoryFactory categoryFactory;
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = createAndSaveProducts(100, 100, 10000);
        List<Category> categories = createAndSaveCategories(10);
    }

    private List<Product> createAndSaveProducts(int numberOfProducts,
                                                int priceLowerBound,
                                                int priceUpperBound) {
        List<Product> newProducts = productFactory.createProducts(numberOfProducts, priceLowerBound,
                priceUpperBound);
        return productService.saveProducts(newProducts);
    }

    private List<Category> createAndSaveCategories(int numberOfCategories) {
        List<Category> newCategories = categoryFactory.createCategories(numberOfCategories);
        return categoryService.saveCategories(newCategories);
    }
}

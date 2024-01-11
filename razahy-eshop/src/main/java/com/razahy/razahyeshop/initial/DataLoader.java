package com.razahy.razahyeshop.initial;

import com.razahy.razahyeshop.model.Category;
import com.razahy.razahyeshop.model.Customer;
import com.razahy.razahyeshop.model.Product;
import com.razahy.razahyeshop.repository.CustomerRepository;
import com.razahy.razahyeshop.service.CategoryService;
import com.razahy.razahyeshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private ProductFactory productFactory;
    private ProductService productService;
    private CategoryFactory categoryFactory;
    private CategoryService categoryService;
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = createAndSaveProducts(100, 100, 10000);
        List<Category> categories = createAndSaveCategories(10);
        assignRandomCategoryToProductAndSave(products, categories);
        customerRepository.save(new Customer("rb@seznam.cz", new BCryptPasswordEncoder().encode(
                "1234"), "user"));
    }

    private List<Product> createAndSaveProducts(int numberOfProducts, int priceLowerBound,
                                                int priceUpperBound) {
        List<Product> newProducts = productFactory.createProducts(numberOfProducts,
                priceLowerBound, priceUpperBound);
        return productService.saveProducts(newProducts);
    }

    private List<Category> createAndSaveCategories(int numberOfCategories) {
        List<Category> newCategories = categoryFactory.createCategories(numberOfCategories);
        return categoryService.saveCategories(newCategories);
    }

    private void assignRandomCategoryToProductAndSave(List<Product> products,
                                                      List<Category> categories) {
        Random rand = new Random();

        for (int i = 0; i < products.size(); i++) {
            products.get(i).setCategory(categories.get(rand.nextInt(0, categories.size())));
        }
        productService.saveProducts(products);
    }
}

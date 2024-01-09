package com.razahy.razahyeshop.initial;

import com.razahy.razahyeshop.model.Product;
import com.razahy.razahyeshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseLoader implements CommandLineRunner {
    private ProductFactory productFactory;
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        List<Product> newProducts = productFactory.createProducts(100, 100,
                10000);
        productService.saveProducts(newProducts);

    }
}

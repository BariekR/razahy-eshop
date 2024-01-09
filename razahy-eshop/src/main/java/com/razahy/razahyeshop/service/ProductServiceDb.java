package com.razahy.razahyeshop.service;

import com.razahy.razahyeshop.model.Product;
import com.razahy.razahyeshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceDb implements ProductService {
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }
}

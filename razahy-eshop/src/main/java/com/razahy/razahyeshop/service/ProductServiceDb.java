package com.razahy.razahyeshop.service;

import com.razahy.razahyeshop.model.Product;
import com.razahy.razahyeshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceDb implements ProductService {
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        productRepository.count();
        return productRepository.findAll(PageRequest.of(0, 15)).toList();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return productRepository.findAllByCategory_Id(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public long countAllProducts() {
        return productRepository.count();
    }
}

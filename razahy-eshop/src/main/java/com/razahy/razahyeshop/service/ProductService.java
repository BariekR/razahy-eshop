package com.razahy.razahyeshop.service;

import com.razahy.razahyeshop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> products);
}

package com.razahy.razahyeshop.service;

import com.razahy.razahyeshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Page<Product> getAllProducts(int pageNumber, int productsPerPage);
    List<Product> getAllProducts();
    List<Product> getProductsByCategoryId(Long id);
    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> products);
    long countAllProducts();
}

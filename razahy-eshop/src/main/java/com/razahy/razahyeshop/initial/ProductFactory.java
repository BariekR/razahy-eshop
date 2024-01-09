package com.razahy.razahyeshop.initial;

import com.razahy.razahyeshop.model.Product;
import com.razahy.razahyeshop.utils.RandomUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductFactory {
    public List<Product> createProducts(int numberOfProducts, int priceLowerBound, int priceUpperBound) {
        List<Product> products = new ArrayList<>(numberOfProducts);
        for (int i = 1; i <= numberOfProducts; i++) {
            products.add(new Product(String.format("Product %d", i), String.format("Product description %d", i),
                    RandomUtil.getRandomBigDecimal(priceLowerBound, priceUpperBound)));
        }
        return products;
    }
}

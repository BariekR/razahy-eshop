package com.razahy.razahyeshop.controller;

import com.razahy.razahyeshop.service.CategoryService;
import com.razahy.razahyeshop.service.ProductService;
import com.razahy.razahyeshop.utils.PaginationUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class WebController {
    private static final int PRODUCTS_PER_PAGE = 15;
    private ProductService productService;
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model, Optional<Integer> page) {
        page = page.filter(x -> x > 0);
        model.addAttribute("products", productService.getAllProducts(page.orElse(1) - 1, PRODUCTS_PER_PAGE));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("pages", PaginationUtil.pages(productService.countAllProducts(), PRODUCTS_PER_PAGE));
        return "index";
    }

    @GetMapping("/categories/{idOfCategory}")
    public String category(@PathVariable Long idOfCategory, Model model) {
        model.addAttribute("products", productService.getProductsByCategoryId(idOfCategory));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }
}

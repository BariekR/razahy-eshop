package com.razahy.razahyeshop.controller;

import com.razahy.razahyeshop.service.CategoryService;
import com.razahy.razahyeshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {
    private ProductService productService;
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }
}

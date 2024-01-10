package com.razahy.razahyeshop.controller;

import com.razahy.razahyeshop.service.CategoryService;
import com.razahy.razahyeshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Controller
@AllArgsConstructor
public class WebController {
    private ProductService productService;
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("pages", LongStream.range(1L, productService.countAllProducts()/10).boxed().collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/products/{idOfCategory}")
    public String category(@PathVariable Long idOfCategory, Model model) {
        model.addAttribute("products", productService.getProductsByCategoryId(idOfCategory));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }
}

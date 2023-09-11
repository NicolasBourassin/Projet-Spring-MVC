package com.example.projetspringmvc.controller;

import com.example.projetspringmvc.repository.entity.Category;
import com.example.projetspringmvc.repository.entity.Product;
import com.example.projetspringmvc.service.CategoryService;
import com.example.projetspringmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    private CategoryService categoryService;
    private ProductService productService;
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;

    }

    @GetMapping("/categories")
    public String displayAllCategories(Model model) {
        try{
            List<Category> categoryList = categoryService.fetchAll();
        model.addAttribute("categories", categoryList);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return "categories";
    }

    @PostMapping("/products/category")
    public String displayProductsByCategory(@RequestParam("categoryId") Long categoryId, Model model) throws Exception {
        // Retrieve the category by ID
        Category category = categoryService.fetchById(categoryId);

        // Retrieve all products belonging to the category
        List<Product> products = productService.findByCategory(category);

        // Pass the products to the Thymeleaf template
        model.addAttribute("products", products);
        return "products"; // Redirect to the products template to display the products
    }
}
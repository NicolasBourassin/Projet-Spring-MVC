package com.example.projetspringmvc.controller;

import com.example.projetspringmvc.repository.entity.Category;
import com.example.projetspringmvc.repository.entity.Product;
import com.example.projetspringmvc.service.CategoryService;
import com.example.projetspringmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        Category category = categoryService.fetchById(categoryId);
        List<Product> products = productService.findByCategory(category);
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/categories/delete/{categoryId}")
    public String deleteCategoryAndProducts(@PathVariable Long categoryId) throws Exception {
        categoryService.deleteCategoryAndProducts(categoryId);
        return "redirect:/categories";
    }

}
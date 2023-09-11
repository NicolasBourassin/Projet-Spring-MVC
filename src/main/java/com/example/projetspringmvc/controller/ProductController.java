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

import java.text.AttributedString;
import java.util.List;

@Controller
public class ProductController {
    private CategoryService categoryService;
    private ProductService productService;
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;

    }

    @GetMapping("/products")
    public String displayAllProducts(Model model){
        try{
            List<Product> productList = productService.fetchAll();
            model.addAttribute("products", productList);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return "products";
    }

    @GetMapping("/products/add")  // TEST : problem linked to GetMapping necessary ?
    public String showAddProductForm(Model model) {
        List<Category> categories = categoryService.fetchAll();
        model.addAttribute("categories", categories);
        return "add-products";
    }
    @PostMapping("/products/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") Float price,
                             @RequestParam("description") String description) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        productService.save(product);
        return "redirect:/products";
    }

}

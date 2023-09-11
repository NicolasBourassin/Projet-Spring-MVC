package com.example.projetspringmvc.controller;

import com.example.projetspringmvc.repository.entity.Product;
import com.example.projetspringmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
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

}

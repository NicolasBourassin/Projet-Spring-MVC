package com.example.projetspringmvc.service;

import com.example.projetspringmvc.repository.CategoryRepository;
import com.example.projetspringmvc.repository.entity.Category;
import com.example.projetspringmvc.repository.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ProductService productService;
    public CategoryService(CategoryRepository categoryRepository, ProductService productService){
        this.categoryRepository = categoryRepository;
        this.productService = productService;

    }

    public Category fetchById(Long id) throws Exception{
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new Exception());
    }

    public List<Category> fetchAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    public void deleteCategoryAndProducts(Long categoryId) throws Exception {
        Category category = fetchById(categoryId);
        List<Product> products = productService.findByCategory(category);

        // We must delete Product instances before the Category
        for (Product product : products) {
            productService.remove(product.getId());
        }

        // Delete the category
        remove(categoryId);
    }
}

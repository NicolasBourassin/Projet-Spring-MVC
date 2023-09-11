package com.example.projetspringmvc.service;

import com.example.projetspringmvc.repository.CategoryRepository;
import com.example.projetspringmvc.repository.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
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

}

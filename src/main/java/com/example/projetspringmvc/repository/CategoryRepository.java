package com.example.projetspringmvc.repository;

import com.example.projetspringmvc.repository.entity.Category;
import com.example.projetspringmvc.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(Category category);

}

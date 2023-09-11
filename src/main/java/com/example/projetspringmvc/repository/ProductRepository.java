package com.example.projetspringmvc.repository;

import com.example.projetspringmvc.repository.entity.Category;
import com.example.projetspringmvc.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);

    //à appeler avant délétion d'une instance de Category !
    List<Product> deleteAllByCategory(Category category);
}

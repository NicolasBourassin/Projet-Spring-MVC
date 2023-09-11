package com.example.projetspringmvc;

import com.example.projetspringmvc.repository.CategoryRepository;
import com.example.projetspringmvc.repository.ProductRepository;
import com.example.projetspringmvc.repository.entity.Category;
import com.example.projetspringmvc.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjetSpringMvc {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProjetSpringMvc(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    };
    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringMvc.class, args);
    }

    @Bean
    @Profile("!test")
    CommandLineRunner commandLineRunner() {
        return args -> {
            //tests ici :
            List<Category> categoryList = new ArrayList<>();
            List<Product> productList = new ArrayList<>();

            Category category1 = new Category("Pantalon", null);
            Category category2 = new Category("Chemise", null);

            categoryList.add(category1);
            categoryList.add(category2);
            categoryRepository.saveAll(categoryList);

            // get Ids of entities in database
            category1 = categoryRepository.findByName(category1);
            category2 = categoryRepository.findByName(category2);

            Product product1 = new Product("PantaBla",25F,"un pantalon blanc", category1);
            Product product2 = new Product("CheGri",25F,"une chemise grise", category2);
            Product product3 = new Product("PantaNo",25F,"un pantalon noir", category1);
            productList.add(product1);
            productList.add(product2);
            productList.add(product3);
            productRepository.saveAll(productList);

        };
    }


    }

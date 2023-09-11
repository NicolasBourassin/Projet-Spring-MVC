package com.example.projetspringmvc.service;

import com.example.projetspringmvc.repository.ProductRepository;
import com.example.projetspringmvc.repository.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product fetchById(Long id) throws Exception{
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new Exception());
    }

    public List<Product> fetchAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void remove(Long id) {
        productRepository.deleteById(id);
    }

}

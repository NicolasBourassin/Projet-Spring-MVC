package com.example.projetspringmvc.repository.entity;



import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="categories")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "names", unique=true)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> product;

    public Category() {
    }

    public Category(Long id, String name, List<Product> product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public Category(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contains " + product.size() + " products" +
                '}';
    }
}

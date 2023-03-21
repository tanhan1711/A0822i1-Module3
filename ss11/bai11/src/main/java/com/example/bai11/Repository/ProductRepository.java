package com.example.bai11.Repository;

import com.example.bai11.bean.Product;

import java.util.List;

public interface ProductRepository {
    void create(Product product);
    void delete(String id);
    void update(Product product);
    List<Product> findAll();
    Product findById(String id);
}

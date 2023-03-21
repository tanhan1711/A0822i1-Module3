package com.example.bai11.Service;

import com.example.bai11.bean.Product;

import java.util.List;

public interface ProductService  {
    void create(Product product);
    void delete(String id);
    void update(Product product);
    List<Product> findAll();
    Product findById(String id);

}


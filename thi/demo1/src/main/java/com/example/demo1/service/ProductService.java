package com.example.demo1.service;

import com.example.demo1.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void add(Product product);
    void update(Product product);
    List<Product> findAll();
    //    List<Product> findByTenloaisach(String name);
    public Product selectNhanVien(int id);

    public boolean deleteUser(int id) throws SQLException;
    List<Product> findByTenProduct(String categoryname);
}

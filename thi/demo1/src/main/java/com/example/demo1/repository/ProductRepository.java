package com.example.demo1.repository;

import com.example.demo1.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    void add(Product product);
    void update(Product product);
    List<Product> findAll();
    List<Product> findByTenProduct(String categoryname);
    public Product selectNhanVien(int id);

    public boolean deleteUser(int id) throws SQLException;
}

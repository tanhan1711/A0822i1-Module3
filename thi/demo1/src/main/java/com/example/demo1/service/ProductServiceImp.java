package com.example.demo1.service;

import com.example.demo1.model.Product;
import com.example.demo1.repository.ProductRepository;
import com.example.demo1.repository.ProductRepositoryImp;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImp implements ProductService{
    ProductRepository repository = new ProductRepositoryImp();

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public void update(Product product) {
         repository.update(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product selectNhanVien(int id) {
        return repository.selectNhanVien(id);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return repository.deleteUser(id);
    }

    @Override
    public List<Product> findByTenProduct(String categoryname) throws SQLException {
        return repository.findByTenProduct(categoryname);
    }
}

package com.example.bai11.Service;

import com.example.bai11.Repository.ProductRepository;
import com.example.bai11.Repository.ProductRepositoryImp;
import com.example.bai11.bean.Product;

import java.util.List;

public class ProductServiceImp implements ProductService {
    private static ProductRepository productRepository = new ProductRepositoryImp();

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void delete(String id) {

        productRepository.delete(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();

    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);

    }
}

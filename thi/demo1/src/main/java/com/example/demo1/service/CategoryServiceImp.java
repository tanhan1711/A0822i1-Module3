package com.example.demo1.service;

import com.example.demo1.model.Category;
import com.example.demo1.repository.CategoryRepository;
import com.example.demo1.repository.CategoryRepositoryImp;

import java.util.List;

public class CategoryServiceImp implements CategoryService{
    CategoryRepository repository = new CategoryRepositoryImp();
    @Override
    public Category findById(String idCategory) {
        return repository.findById(idCategory);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}

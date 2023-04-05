package com.example.demo1.repository;

import com.example.demo1.model.Category;

import java.util.List;

public interface CategoryRepository {
    Category findById(String idCategory);
    List<Category> findAll();
}

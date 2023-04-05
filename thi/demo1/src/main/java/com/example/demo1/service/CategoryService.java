package com.example.demo1.service;

import com.example.demo1.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(String idCategory);
    List<Category> findAll();
}

package com.ecommerece.project.service;

import com.ecommerece.project.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    void createCategory(Category categoryName);

    String deleteCategory(Long categoryId);

     Category updateCategory(Category category, Long categoryId);
}

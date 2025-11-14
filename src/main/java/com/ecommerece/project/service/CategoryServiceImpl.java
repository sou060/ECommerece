package com.ecommerece.project.service;

import com.ecommerece.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category categoryName) {
        categories.add(categoryName);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category categoryName = categories.stream().
                filter(c -> c.getCategoryId().
                        equals(categoryId)).findFirst().
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Category not found " + categoryId));
        if (categoryName == null) {
            return "Category not found " + categoryId;
        }
        categories.remove(categoryName);
        return "Category deleted successfully " + categoryId;
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categories.stream().
                filter(c -> c.getCategoryId().
                        equals(categoryId)).
                findFirst();
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Category not found " + categoryId);
    }

}

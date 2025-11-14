package com.ecommerece.project.controller;

import com.ecommerece.project.model.Category;
import com.ecommerece.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("categories")
    public ResponseEntity<List<Category>> getCategories() {

        List<Category> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Categpry added successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try {
            String status=categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status,HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }
    @PutMapping("categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable Long categoryId) {
        try {
            Category updatedCategory=categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>(updatedCategory.toString(),HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }

}

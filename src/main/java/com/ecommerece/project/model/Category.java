package com.ecommerece.project.model;

public class Category {
    private Long CategoryId;
    private String CategoryName;

    @Override
    public String toString() {
        return "Category {" +"\n"+
                "Category with category id: "+getCategoryId() +
                "\n"+
                "Category with category name: "+getCategoryName()+ "\n"+
                "}";
    }

    public Category(Long categoryId, String categoryName) {
        CategoryId = categoryId;
        CategoryName = categoryName;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}

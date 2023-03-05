package com.example.myproject_be.service;

import com.example.myproject_be.entity.document.Category;

import java.util.List;

public interface CategoryService {
    //    ~~~ Get all Category
    List<Category> getCategory();

    //    ~~~ Delete category with id
    void deleteCategory(String name);

    //    ~~~ Create category
    void addCategory(String category);

    //    ~~~ Find category by name
    Category findCategoryByName(String name);
}

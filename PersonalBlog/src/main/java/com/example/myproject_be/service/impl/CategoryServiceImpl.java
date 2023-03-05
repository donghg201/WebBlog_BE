package com.example.myproject_be.service.impl;

import com.example.myproject_be.entity.document.Category;
import com.example.myproject_be.repository.CategoryRepository;
import com.example.myproject_be.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepository.getCategory();
    }

    @Override
    public void deleteCategory(String name) {
        categoryRepository.deleteCategory(name);
    }

    @Override
    public void addCategory(String category_name) {
        categoryRepository.createCategory(category_name, 1);
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }
}

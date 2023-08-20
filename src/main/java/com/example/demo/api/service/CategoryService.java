package com.example.demo.api.service;

import com.example.demo.api.controller.CustomException;
import com.example.demo.api.model.Category;
import com.example.demo.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryByCategoryID(Integer categoryID) {
        return categoryRepository.findByCategoryID(categoryID);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.getALlCategories();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category editCategory(Integer categoryID, Category category) {
        // find the user by id using userRepository
        Category existingCategory = categoryRepository.findByCategoryID(categoryID);
        if (existingCategory == null) {
            // throw a custom exception if not found
            throw new CustomException("Category not found", "CATEGORY_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        // update the user's properties using the user object from the request body
        existingCategory.setCategoryName(category.getCategoryName());
        // save the updated user using userRepository
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Integer categoryID) {
        // find the user by id using userRepository
        Category existingCategory = categoryRepository.findByCategoryID(categoryID);
        if (existingCategory == null) {
            // throw a custom exception if not found
            throw new CustomException("Category not found", "CATEGORY_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        // delete the user by id using userRepository
        existingCategory.setDeleteFlg(true);
        categoryRepository.save(existingCategory);
    }
}

package com.example.demo.api.controller;

import com.example.demo.api.model.Category;
import com.example.demo.api.model.User;
import com.example.demo.api.service.CategoryService;
import com.example.demo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public Object getCategory(@RequestParam Optional<Integer> categoryID) {
        if (categoryID.isPresent()) {
            // return a list with one user by id
            return categoryService.getCategoryByCategoryID(categoryID.get());
        } else {
            // return a list with all users
            return categoryService.getAllCategory();
        }
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category) {
        // save the user to the database using userService
        return categoryService.saveCategory(category);
    }
    @GetMapping("/category/{categoryID}")
    public Category getCategory(@PathVariable Integer categoryID) {
        // call the userService to edit the user by id
        return categoryService.getCategoryByCategoryID(categoryID);
    }

    @PutMapping("/category/{categoryID}")
    public Category editCategory(@PathVariable Integer categoryID, @RequestBody Category category) {
        // call the userService to edit the user by id
        return categoryService.editCategory(categoryID, category);
    }

    @DeleteMapping("/category/{categoryID}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer categoryID) {
        // call the userService to delete the user by id
        categoryService.deleteCategory(categoryID);
        // return a response entity with no body and the HTTP status code 204
        return ResponseEntity.noContent().build();
    }
}

package com.example.demo.api.repository;

import com.example.demo.api.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query(value = "SELECT c FROM Category c")
    List<Category> getALlCategories();

    @Query(value = "SELECT c FROM Category c WHERE c.CategoryID = :categoryID")
    Category findByCategoryID(@Param("categoryID") int categoryID);


}

package com.example.demo.api.repository;

import com.example.demo.api.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(value = "SELECT p FROM Product p")
    List<Product> getAllProducts();

    @Query(value = "SELECT p FROM Product p WHERE p.ProductID = :productID")
    Product findByProductID(@Param("productID") int productID);


}

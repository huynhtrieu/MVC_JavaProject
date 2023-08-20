package com.example.demo.api.controller;

import com.example.demo.api.model.Product;
import com.example.demo.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Object getProduct(@RequestParam Optional<Integer> productID) {
        if (productID.isPresent()) {
            // return a list with one user by id
            return productService.getProductByProductID(productID.get());
        } else {
            // return a list with all users
            return productService.getAllProduct();
        }
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        // save the user to the database using userService
        return productService.saveProduct(product);
    }
    @GetMapping("/product/{productID}")
    public Product getProduct(@PathVariable Integer productID) {
        // call the userService to edit the user by id
        return productService.getProductByProductID(productID);
    }

    @PutMapping("/product/{productID}")
    public Product editProduct(@PathVariable Integer productID, @RequestBody Product product) {
        // call the userService to edit the user by id
        return productService.editProduct(productID, product);
    }

    @DeleteMapping("/product/{productID}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productID) {
        // call the userService to delete the user by id
        productService.deleteProduct(productID);
        // return a response entity with no body and the HTTP status code 204
        return ResponseEntity.noContent().build();
    }
}


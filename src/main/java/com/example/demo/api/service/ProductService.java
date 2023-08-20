package com.example.demo.api.service;

import com.example.demo.api.controller.CustomException;
import com.example.demo.api.model.Product;
import com.example.demo.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductByProductID(Integer productID) {
        return productRepository.findByProductID(productID);
    }

    public List<Product> getAllProduct() {
        return productRepository.getAllProducts();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product editProduct(Integer productID, Product product) {
        // find the user by id using userRepository
        Product existingProduct = productRepository.findByProductID(productID);
        if (existingProduct == null) {
            // throw a custom exception if not found
            throw new CustomException("Product not found", "PRODUCT_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        // update the user's properties using the user object from the request body
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        // save the updated user using userRepository
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Integer productID) {
        // find the user by id using userRepository
        Product existingProduct = productRepository.findByProductID(productID);
        if (existingProduct == null) {
            // throw a custom exception if not found
            throw new CustomException("Product not found", "PRODUCT_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        // delete the user by id using userRepository
        existingProduct.setDeleteFlg(true);
        productRepository.save(existingProduct);
    }
}
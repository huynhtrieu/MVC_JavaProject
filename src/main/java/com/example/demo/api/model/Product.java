package com.example.demo.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer ProductID;

    @Column(name = "ProductName", length = 255, nullable = false)
    private String ProductName;

    @Column(name = "Price", precision = 10, scale = 2, nullable = false)
    private Double Price;

    @Column(name = "DeleteFlg")
    private Boolean DeleteFlg = false;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private Category category;

    public Product(String productName, Double price, Category category) {
        this.ProductName = productName;
        this.Price = price;
        this.category = category;
    }

    protected Product() {

    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        this.ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Boolean getDeleteFlg() {
        return DeleteFlg;
    }

    public void setDeleteFlg(Boolean deleteFlg) {
        DeleteFlg = deleteFlg;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

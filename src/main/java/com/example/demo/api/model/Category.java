package com.example.demo.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories", schema = "intern202308")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID", nullable = false, unique = true)
    private Integer CategoryID;
    @Column(name = "CategoryName", length = 255, nullable = false)
    private String CategoryName;
    @Column(name = "DeleteFlg", length = 1)
    private Boolean DeleteFlg = false;

    public Category(String categoryName) {
        CategoryName = categoryName;
    }

    protected Category() {

    }

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public Boolean getDeleteFlg() {
        return DeleteFlg;
    }

    public void setDeleteFlg(Boolean deleteFlg) {
        DeleteFlg = deleteFlg;
    }
}
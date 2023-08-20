package com.example.demo.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderitems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private Integer ItemID;

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Order Order;

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Product Product;

    @Column(name = "Quantity", nullable = false)
    private Integer Quantity;

    @Column(name = "Price", precision = 10, scale = 2, nullable = false)
    private BigDecimal Price;

    @Column(name = "DeleteFlg")
    private Boolean DeleteFlg = false;

    protected OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, BigDecimal price) {
        this.Order = order;
        this.Product = product;
        this.Quantity = quantity;
        this.Price = price;
    }

    public Integer getItemID() {
        return ItemID;
    }

    public void setItemID(Integer itemID) {
        ItemID = itemID;
    }

    public com.example.demo.api.model.Order getOrder() {
        return Order;
    }

    public void setOrder(com.example.demo.api.model.Order order) {
        Order = order;
    }

    public com.example.demo.api.model.Product getProduct() {
        return Product;
    }

    public void setProduct(com.example.demo.api.model.Product product) {
        Product = product;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public Boolean getDeleteFlg() {
        return DeleteFlg;
    }

    public void setDeleteFlg(Boolean deleteFlg) {
        DeleteFlg = deleteFlg;
    }
}
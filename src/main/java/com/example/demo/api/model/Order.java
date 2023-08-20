package com.example.demo.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer OrderID;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private User User;

    @Column(name = "OrderDate")
    private Date OrderDate;

    @Column(name = "TotalAmount", precision = 10, scale = 2, nullable = false)
    private BigDecimal TotalAmount;

    @Column(name = "DeleteFlg")
    private Boolean DeleteFlg = false;

    public Order(com.example.demo.api.model.User user, Date orderDate, BigDecimal totalAmount) {
        this.User = user;
        this.OrderDate = orderDate;
        this.TotalAmount = totalAmount;
    }
    protected Order(){

    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        TotalAmount = totalAmount;
    }

    public Boolean getDeleteFlg() {
        return DeleteFlg;
    }

    public void setDeleteFlg(Boolean deleteFlg) {
        DeleteFlg = deleteFlg;
    }
}

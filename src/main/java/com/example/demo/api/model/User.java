package com.example.demo.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users", schema = "intern202308")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false, unique = true)
    private Integer UserID;
    @Column(name = "UserName", length = 255, nullable = false)
    private String UserName;
    @Column(name = "DeleteFlg", length = 1)
    private Boolean DeleteFlg = false;

    public User(String userName) {
        UserName = userName;
    }

    protected User() {

    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Boolean getDeleteFlg() {
        return DeleteFlg;
    }

    public void setDeleteFlg(Boolean deleteFlg) {
        DeleteFlg = deleteFlg;
    }
}
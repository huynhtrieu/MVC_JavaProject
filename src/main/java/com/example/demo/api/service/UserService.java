package com.example.demo.api.service;

import com.example.demo.api.controller.CustomException;
import com.example.demo.api.model.Order;
import com.example.demo.api.model.OrderItem;
import com.example.demo.api.model.User;
import com.example.demo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Integer userID) {
        return userRepository.findByUserID(userID);
    }

    public List<User> getAllUser() {
        return userRepository.getALlUsers();
    }
    public List<Order> getUserOrders(Integer userID) {
        return userRepository.getUserOrders(userID);
    }
    public List<OrderItem> getUserOrderItemsByOrderID(Integer userID, Integer orderID) {
        return userRepository.getUserOrderDetailByOrderID(userID, orderID);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(Integer userID, User user) {
        // find the user by id using userRepository
        User existingUser = userRepository.findByUserID(userID);
        if (existingUser == null) {
            // throw a custom exception if not found
            throw new CustomException("User not found", "USER_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        // update the user's properties using the user object from the request body
        existingUser.setUserName(user.getUserName());
        // save the updated user using userRepository
        return userRepository.save(existingUser);
    }

    public void deleteUser(Integer userID) {
        // find the user by id using userRepository
        User existingUser = userRepository.findByUserID(userID);
        if (existingUser == null) {
            // throw a custom exception if not found
            throw new CustomException("User not found", "USER_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        // delete the user by id using userRepository
        existingUser.setDeleteFlg(true);
        userRepository.save(existingUser);
    }
}

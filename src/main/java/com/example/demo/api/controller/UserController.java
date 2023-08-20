package com.example.demo.api.controller;

import com.example.demo.api.model.User;
import com.example.demo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Object getUser(@RequestParam Optional<Integer> userID) {
        if (userID.isPresent()) {
            // return a list with one user by id
            return userService.getUserById(userID.get());
        } else {
            // return a list with all users
            return userService.getAllUser();
        }
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        // save the user to the database using userService
        return userService.saveUser(user);
    }
    @GetMapping("/user/{userID}")
    public User getUser(@PathVariable Integer userID) {
        // call the userService to edit the user by id
        return userService.getUserById(userID);
    }
    @GetMapping("/user/{userID}/orders")
    public Object getUserOrders(@PathVariable Integer userID) {
        // call the userService to edit the user by id
        return userService.getUserOrders(userID);
    }
    @GetMapping("/user/{userID}/orders/{orderID}")
    public Object getUserOrders(@PathVariable Integer userID, @PathVariable Integer orderID) {
        // call the userService to edit the user by id
        return userService.getUserOrderItemsByOrderID(userID, orderID);
    }
    @PutMapping("/user/{userID}")
    public User editUser(@PathVariable Integer userID, @RequestBody User user) {
        // call the userService to edit the user by id
        return userService.editUser(userID, user);
    }

    @DeleteMapping("/user/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userID) {
        // call the userService to delete the user by id
        userService.deleteUser(userID);
        // return a response entity with no body and the HTTP status code 204
        return ResponseEntity.noContent().build();
    }
}

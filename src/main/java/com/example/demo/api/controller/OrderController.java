package com.example.demo.api.controller;

import com.example.demo.api.model.Order;
import com.example.demo.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public Object getOrder(@RequestParam Optional<Integer> orderID) {
        if (orderID.isPresent()) {
            // return a list with one user by id
            return orderService.getOrderByOrderID(orderID.get());
        } else {
            // return a list with all users
            return orderService.getAllOrder();
        }
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
        // save the user to the database using userService
        return orderService.saveOrder(order);
    }
    @GetMapping("/order/{orderID}")
    public Order getOrder(@PathVariable Integer orderID) {
        // call the userService to edit the user by id
        return orderService.getOrderByOrderID(orderID);
    }
    @GetMapping("/order/{orderID}/orderitems")
    public Object getOrderItems(@PathVariable Integer orderID) {
        // call the userService to edit the user by id
        return orderService.getOrderItems(orderID);
    }

    @PutMapping("/order/{orderID}")
    public Order editOrder(@PathVariable Integer orderID, @RequestBody Order order) {
        // call the userService to edit the user by id
        return orderService.editOrder(orderID, order);
    }

    @DeleteMapping("/order/{orderID}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderID) {
        // call the userService to delete the user by id
        orderService.deleteOrder(orderID);
        // return a response entity with no body and the HTTP status code 204
        return ResponseEntity.noContent().build();
    }
}

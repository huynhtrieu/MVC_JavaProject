package com.example.demo.api.controller;

import com.example.demo.api.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/orderitems")
    public Object getOrderItems(@RequestParam Optional<Integer> itemID) {
        if (itemID.isPresent()) {
            // return a list with one user by id
            return orderItemService.getOrderItemByOrderItemID(itemID.get());
        } else {
            // return a list with all users
            return orderItemService.getAllOrderItem();
        }
    }
}

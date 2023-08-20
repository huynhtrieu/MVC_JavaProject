package com.example.demo.api.service;

import com.example.demo.api.controller.CustomException;
import com.example.demo.api.model.Order;
import com.example.demo.api.model.OrderItem;
import com.example.demo.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderByOrderID(Integer orderID) {
        return orderRepository.findByOrderID(orderID);
    }

    public List<Order> getAllOrder() {
        return orderRepository.getALlOrders();
    }
    public List<OrderItem> getOrderItems(Integer orderID) {
        return orderRepository.getOrderItems(orderID);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order editOrder(Integer orderID, Order order) {
        // find the user by id using userRepository
        Order existingOrder = orderRepository.findByOrderID(orderID);
        if (existingOrder == null) {
            // throw a custom exception if not found
            throw new CustomException("Order not found", "ORDER_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        // update the user's properties using the user object from the request body
        existingOrder.setUser(order.getUser());
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setTotalAmount(order.getTotalAmount());
        // save the updated user using userRepository
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Integer orderID) {
        // find the user by id using userRepository
        Order existingOrder = orderRepository.findByOrderID(orderID);
        if (existingOrder == null) {
            // throw a custom exception if not found
            throw new CustomException("Order not found", "Order_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        // delete the user by id using userRepository
        existingOrder.setDeleteFlg(true);
        orderRepository.save(existingOrder);
    }
}

package com.example.demo.api.service;

import com.example.demo.api.model.OrderItem;
import com.example.demo.api.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem getOrderItemByOrderItemID(Integer itemID) {
        return orderItemRepository.findByItemID(itemID);
    }

    public List<OrderItem> getAllOrderItem() {
        return orderItemRepository.getALlOrderItems();
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

}

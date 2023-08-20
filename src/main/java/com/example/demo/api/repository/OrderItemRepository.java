package com.example.demo.api.repository;

import com.example.demo.api.model.Order;
import com.example.demo.api.model.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
    @Query(value = "SELECT oi FROM OrderItem oi")
    List<OrderItem> getALlOrderItems();
    @Query(value = "SELECT oi FROM OrderItem oi WHERE oi.ItemID = :itemID")
    OrderItem findByItemID(@Param("itemID") int itemID);
}

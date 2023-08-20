package com.example.demo.api.repository;

import com.example.demo.api.model.Order;
import com.example.demo.api.model.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query(value = "SELECT o FROM Order o")
    List<Order> getALlOrders();

    @Query(value = "SELECT oi FROM OrderItem oi WHERE oi.Order.OrderID = :orderID")
    List<OrderItem> getOrderItems(@Param("orderID") int orderID);

    @Query(value = "SELECT o FROM Order o WHERE o.OrderID = :orderID")
    Order findByOrderID(@Param("orderID") int orderID);
}

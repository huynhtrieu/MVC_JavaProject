package com.example.demo.api.repository;

import com.example.demo.api.model.Order;
import com.example.demo.api.model.OrderItem;
import com.example.demo.api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u")
    List<User> getALlUsers();

    @Query(value = "SELECT u FROM User u WHERE u.UserID = :userID")
    User findByUserID(@Param("userID") int userID);

    @Query(value = "SELECT o FROM Order o WHERE o.User.UserID = :userID")
    List<Order> getUserOrders(@Param("userID") int userID);
//    @Query(value = "SELECT oi FROM OrderItem oi WHERE oi.Order.OrderID = :orderID")
    @Query(value = "SELECT oi FROM OrderItem oi INNER JOIN oi.Order o INNER JOIN o.User u WHERE o.OrderID = :orderID AND u.UserID = :userID")
    List<OrderItem> getUserOrderDetailByOrderID(@Param("userID") int userID, @Param("orderID") int orderID);

}

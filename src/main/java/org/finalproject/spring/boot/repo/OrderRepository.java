package org.finalproject.spring.boot.repo;

import org.finalproject.spring.boot.entities.Holdings;
import org.finalproject.spring.boot.entities.Order;
import org.finalproject.spring.boot.entities.Security;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    //            this.security = security;
//        this.quantity = quantity;
//        this.executeBy = executeBy;
//        this.executePrice = executePrice;
//        this.orderPlacedTime = orderPlacedTime;
//        this.orderType = orderType;
    Order getById(int id);

    List<Order> getBySecurity(int sid);
    List<Order> getByOrderType(String orderType);
    List<Order> getByQuantityHigherThan(int quantity);


}

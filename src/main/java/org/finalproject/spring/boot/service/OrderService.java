package org.finalproject.spring.boot.service;

import org.finalproject.spring.boot.entities.Order;
import org.finalproject.spring.boot.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.getById(id);
    }

    public List<Order> getOrderBySecurity(int sid) {
        return orderRepository.getBySecurity(sid);
    }

    public List<Order> getOrderByOrderType(String orderType) {
        return orderRepository.getByOrderType(orderType);
    }

    public List<Order> getQuantityHigherThan(int quantity) {
        return orderRepository.getByQuantityHigherThan(quantity);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

}

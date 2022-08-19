package org.finalproject.spring.boot.service;

import org.finalproject.spring.boot.entities.Order;
import org.finalproject.spring.boot.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
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
        return orderRepository.getBySecurityId(sid);
    }

    public List<Order> getOrderByOrderType(String orderType) {
        return orderRepository.getByOrderType(orderType);
    }


    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

}

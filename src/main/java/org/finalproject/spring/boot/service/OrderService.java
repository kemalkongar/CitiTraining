package org.finalproject.spring.boot.service;

import org.finalproject.spring.boot.entities.Order;
import org.finalproject.spring.boot.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SecurityService securityService;

    public List<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> listAllOrderQueue() {

        List<Order> res = new ArrayList<>(Order.pendingBuyOrders);
        res.addAll(new ArrayList<>(Order.pendingSellOrders));
        return res;
    }
    public String getTickerBySid(int sid) {
        return orderRepository.getTickerBySecurityId(sid);
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

    public void placeOrder(Order order) {
        if (order.getOrderPlacedTime()==null){
            order.setOrderPlacedTime();
        }

        if (order.getSecurityId()==null && order.getSecurityName() != null){
            order.setSecurityId(orderRepository.getSecurityIdeByTicker(order.getSecurityName()));
        }
        order.setOrderStatus(Order.OrderStatus.PENDING);

        if (order.getOrderType().equals("BUY") &&
                order.getExecutePrice()<securityService.getSecurityById(order.getSecurityId()).getT0()){
            Order.pendingBuyOrders.add(order);

        } else if (order.getOrderType().equals("SELL") &&
                order.getExecutePrice()>securityService.getSecurityById(order.getSecurityId()).getT0()){
            Order.pendingSellOrders.add(order);

        } else { // price match
            this.executeOrder(order);
        }
        String securityName = orderRepository.getTickerBySecurityId(order.getSecurityId());
        order.setSecurityName(securityName);
        orderRepository.save(order);
    }

    public void executeOrder(Order order) {
        try {
            // TODO: detailed process of execution, currently just assume every execution succeeds
            order.setOrderStatus(Order.OrderStatus.SUCCESS);
        } catch (Exception e) {
            order.setOrderStatus(Order.OrderStatus.INCOMPLETE);
        }
    }

    public void removeOrder(int i){
        orderRepository.deleteById(i);
    }
}

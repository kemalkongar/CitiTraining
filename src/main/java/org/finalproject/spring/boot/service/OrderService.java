package org.finalproject.spring.boot.service;

import org.finalproject.spring.boot.entities.Holdings;
import org.finalproject.spring.boot.entities.Order;
import org.finalproject.spring.boot.repo.HoldingsRepository;
import org.finalproject.spring.boot.repo.OrderRepository;
import org.finalproject.spring.boot.repo.SecurityRepository;
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
    private HoldingsRepository holdingsRepository;
    @Autowired
    private SecurityRepository securityRepository;

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
        int exists = holdingsRepository.checkIfSecurityExist(order.getSecurityId());
        int currLot=0;
        String company = orderRepository.getCompanyNameBySecurityId(order.getSecurityId());

        if (exists>0){
            currLot = holdingsRepository.getLotFromSid(order.getSecurityId());

        }

        Holdings myHoldings = new Holdings(order.getSecurityId(), order.getSecurityName(), company, currLot+1, securityRepository.getCurrPriceFromSid(order.getSecurityId()));
        if (exists>0){
            // I heard save() to jpa can also do update but I'm not sure
            myHoldings.setId(holdingsRepository.getIdFromSid(order.getSecurityId()));
        }
        orderRepository.save(order);
        holdingsRepository.save(myHoldings);
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

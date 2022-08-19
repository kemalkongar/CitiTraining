package org.finalproject.spring.boot.controller;

import org.finalproject.spring.boot.entities.Holdings;
import org.finalproject.spring.boot.entities.Order;
import org.finalproject.spring.boot.entities.Security;
import org.finalproject.spring.boot.service.HoldingsService;
import org.finalproject.spring.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@ComponentScan("org.finalproject.spring.boot")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public List<Order> list() {
        return orderService.listAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/security/{security}")
    public List<Order> getOrderBySecurity(@PathVariable Integer security) {
        return orderService.getOrderBySecurity(security);
    }

    @PostMapping(value = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

}

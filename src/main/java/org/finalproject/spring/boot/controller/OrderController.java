package org.finalproject.spring.boot.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.finalproject.spring.boot.entities.Holdings;
import org.finalproject.spring.boot.entities.Order;
import org.finalproject.spring.boot.entities.Security;
import org.finalproject.spring.boot.service.HoldingsService;
import org.finalproject.spring.boot.service.OrderService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@ComponentScan("org.finalproject.spring.boot")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public List<Object> list() {
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

    @GetMapping("/queue")
    public ResponseEntity<java.lang.String> getOrderQueue() {
        JSONArray jsonArray = new JSONArray();
        List<Order> myQueue = orderService.listAllOrderQueue();
        for (Order o:myQueue){

            JSONObject jsonObj= new JSONObject();
            jsonObj.put("order_type", o.getOrderType());
            jsonObj.put("ticker", orderService.getTickerBySid(o.getSecurityId()));
            jsonObj.put("quantity", o.getQuantity());
            jsonObj.put("price", o.getExecutePrice());
            jsonObj.put("status", o.getOrderStatus());
            jsonArray.put(jsonObj);
        }
        return new ResponseEntity<String>(new JSONObject().put("order queue", jsonArray).toString(), HttpStatus.OK);
    }

    @PostMapping(value = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addOrder(@RequestBody Order order) {
        orderService.placeOrder(order);
    }

    @DeleteMapping(value = "/removeOrder/{delId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeOrder(@PathVariable Integer delId) {
        orderService.removeOrder(delId);
    }
}

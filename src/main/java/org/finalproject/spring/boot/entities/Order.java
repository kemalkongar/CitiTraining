package org.finalproject.spring.boot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "Orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "security_id")
    private int securityId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "execute_by")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate executeBy;

    @Column(name = "execute_price")
    private double executePrice;

    @Column(name = "order_placed_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderPlacedTime;

    @Column(name = "order_type")
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    public static PriorityQueue<Order> pendingBuyOrders = new PriorityQueue<Order>( new BuyOrderComparator());
    public static PriorityQueue<Order> pendingSellOrders = new PriorityQueue<Order>( new SellOrderComparator());

    public int getId() {
        return id;
    }

    public int getSecurityId() {
        return securityId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExecuteBy() {
        return executeBy;
    }
    public String getOrderStatus() {
        return orderStatus.toString();
    }

    public void setExecuteBy(LocalDate executeBy) {
        this.executeBy = executeBy;
    }

    public double getExecutePrice() {
        return executePrice;
    }


    public enum OrderStatus {
        PENDING,
        SUCCESS,
        FAILED,
        INCOMPLETE
    }

    public enum OrderType {
        BUY,
        SELL
    }

    public void setExecutePrice(double executePrice) {
        this.executePrice = executePrice;
    }
    public void setOrderStatus(OrderStatus m) {
        // test if the order status is propagated to the database
        this.orderStatus = m;}
    public void setOrderType(OrderType m) {this.orderType = m;}


    public LocalDate getOrderPlacedTime() {
        return orderPlacedTime;
    }


    public String getOrderType() {

        return orderType.toString();
    }
    public Order(int security, int quantity, LocalDate executeBy, double executePrice, LocalDate orderPlacedTime, OrderType orderType) {
        this.securityId = security;
        this.quantity = quantity;
        this.executeBy = executeBy;
        this.executePrice = executePrice;
        this.orderPlacedTime = orderPlacedTime;
        this.orderType = orderType;
    }

    public Order(int id){
        this.id=id;
    }

    public Order(){
    }

}

class BuyOrderComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        if (order1.getExecutePrice() < order2.getExecutePrice())
            return -1;
        else if (order1.getExecutePrice() > order2.getExecutePrice())
            return 1;
        return 0;
    }
}

class SellOrderComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        if (order1.getExecutePrice() < order2.getExecutePrice())
            return 1;
        else if (order1.getExecutePrice() > order2.getExecutePrice())
            return -1;
        return 0;
    }
}
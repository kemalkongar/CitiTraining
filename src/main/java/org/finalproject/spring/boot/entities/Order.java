package org.finalproject.spring.boot.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "security")
    private int security;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "exchange")
    private LocalDate executeBy;

    @Column(name = "executePrice")
    private double executePrice;

    @Column(name = "orderPlacedTime")
    private LocalDate orderPlacedTime;

    @Column(name = "orderType")
    private String orderType;

    public int getId() {
        return id;
    }

    public int getSecurity() {
        return security;
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

    public void setExecuteBy(LocalDate executeBy) {
        this.executeBy = executeBy;
    }

    public double getExecutePrice() {
        return executePrice;
    }

    public void setExecutePrice(double executePrice) {
        this.executePrice = executePrice;
    }

    public LocalDate getOrderPlacedTime() {
        return orderPlacedTime;
    }


    public String getOrderType() {
        return orderType;
    }

    public Order(int security, int quantity, LocalDate executeBy, double executePrice, LocalDate orderPlacedTime, String orderType) {
        this.security = security;
        this.quantity = quantity;
        this.executeBy = executeBy;
        this.executePrice = executePrice;
        this.orderPlacedTime = orderPlacedTime;
        this.orderType = orderType;
    }

}

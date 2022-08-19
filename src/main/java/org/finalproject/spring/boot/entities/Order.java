package org.finalproject.spring.boot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "security_id")
    private int securityId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "execute_by")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate executeBy;

    @Column(name = "execute_price")
    private double executePrice;

    @Column(name = "order_placed_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderPlacedTime;

    @Column(name = "order_type")
    private String orderType;

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
        return orderStatus;
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

    public Order(int security, int quantity, String orderStatus, LocalDate executeBy, double executePrice, LocalDate orderPlacedTime, String orderType) {
        this.securityId = security;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.executeBy = executeBy;
        this.executePrice = executePrice;
        this.orderPlacedTime = orderPlacedTime;
        this.orderType = orderType;
    }

    public Order(){
    }

}

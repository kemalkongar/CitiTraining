package org.finalproject.spring.boot.entities;

import javax.persistence.*;

@Entity
@Table(name = "Securities")

public class Security {
    //@Column(name = "idSecurities")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name = "ticker")
    private String ticker;
    //@Column(name = "name")
    private String name;
    //Column(name = "exchange")
    private String exchange;

    @Column(name = "current_price")
    private double currentPrice;


    public Security() {
    }

    public Security(String ticker, String name, String exchange, double currentPrice) {
        this.ticker = ticker;
        this.name = name;
        this.exchange = exchange;
        this.currentPrice = currentPrice;
    }

    public Security(int id, String ticker, String name, String exchange, double currentPrice) {
        this.id = id;
        this.ticker = ticker;
        this.name = name;
        this.exchange = exchange;
        this.currentPrice = currentPrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}

package org.finalproject.spring.boot.entities;

import javax.persistence.*;

@Entity
@Table(name = "securities")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSecurities")
    private int idSecurities;

    @Column(name = "ticker")
    private String ticker;
    @Column(name = "name")
    private String name;
    @Column(name = "exchange")
    private String exchange;

    @Column(name = "currentPrice")
    private double currentPrice;

    public Security(String ticker, String name, String exchange, double currentPrice) {
        this.ticker = ticker;
        this.name = name;
        this.exchange = exchange;
        this.currentPrice = currentPrice;
    }

    public int getIdSecurities() {
        return idSecurities;
    }

    public String getTicker() {
        return ticker;
    }

    public String getName() {
        return name;
    }

    public String getExchange() {
        return exchange;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}

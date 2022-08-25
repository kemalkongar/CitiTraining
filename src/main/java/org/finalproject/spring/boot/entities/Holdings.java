package org.finalproject.spring.boot.entities;

import javax.persistence.*;

@Entity
@Table(name = "Holdings")
public class Holdings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "security")
    private int security;

    @Column(name = "security_ticker")
    private String securityTicker;
    @Column(name = "security_name")
    private String securityName;
    @Column(name = "lot")
    private int lot;

    @Column(name = "buy_price")
    private double buyPrice;


    public Holdings() {
    }

    public Holdings(int security, String security_ticker, String security_name, int lot, double buyPrice) {
        this.security = security;
        this.securityTicker = security_ticker;
        this.securityName = security_name;
        this.lot = lot;
        this.buyPrice = buyPrice;
    }

    public String getSecurity_ticker() {
        return securityTicker;
    }

    public void setSecurity_ticker(String security_ticker) {
        this.securityTicker = security_ticker;
    }

    public String getSecurity_name() {
        return securityName;
    }

    public void setSecurity_name(String security_name) {
        this.securityName = security_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }
}

package org.finalproject.spring.boot.entities;

import javax.persistence.*;

@Entity
@Table(name = "Holdings")
public class Holdings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int security;
    private int lot;

    @Column(name = "buy_price")
    private double buyPrice;


    public Holdings() {
    }

    public Holdings(int security, int lot, double buyPrice) {
        this.security = security;
        this.lot = lot;
        this.buyPrice = buyPrice;
    }

    public Holdings(int id, int security, int lot, double buyPrice) {
        this.id = id;
        this.security = security;
        this.lot = lot;
        this.buyPrice = buyPrice;
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

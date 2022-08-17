package org.finalproject.spring.boot.entities;

import javax.persistence.*;

@Entity
@Table(name = "holdings")
public class Holding {
    @Id
    @Column(name = "idULot")
    private int idULot;

    @Column(name = "security")
    private int security;
    @Column(name = "lot")
    private int lot;
    @Column(name = "buyPrice")
    private double buyPrice;

    public Holding() {
    }

    // the PK of the holdings table (idULot) is set as AUTOINCREMENT
    // no need to specify in entity class
    public Holding(int security, int lot, double buyPrice) {
        security = security;
        lot = lot;
        buyPrice = buyPrice;
    }

    public int getSecurity() {
        return security;
    }

    public int getLot() {
        return lot;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getidULot() {
        return idULot;
    }


}

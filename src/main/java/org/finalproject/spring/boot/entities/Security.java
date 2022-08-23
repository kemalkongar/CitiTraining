package org.finalproject.spring.boot.entities;

import javax.persistence.*;

@Entity
@Table(name = "Securities")

public class Security {
    //@Column(name = "idSecurities")
    @Id
    private int id;

    //@Column(name = "ticker")
    private String ticker;
    //@Column(name = "name")
    private String name;
    //Column(name = "exchange")
    private String exchange;

    private double t0;
    private double tminus1;
    private double tminus2;
    private double tminus3;
    private double tminus4;
    private double tminus5;
    private double tminus6;
    private double tminus7;
    private double tminus8;
    private double tminus9;



    public Security() {
    }

    public Security(int id, String ticker, String name, String exchange, double t0, double tminus1, double tminus2, double tminus3, double tminus4, double tminus5, double tminus6, double tminus7, double tminus8, double tminus9) {
        this.id = id;
        this.ticker = ticker;
        this.name = name;
        this.exchange = exchange;
        this.t0 = t0;
        this.tminus1 = tminus1;
        this.tminus2 = tminus2;
        this.tminus3 = tminus3;
        this.tminus4 = tminus4;
        this.tminus5 = tminus5;
        this.tminus6 = tminus6;
        this.tminus7 = tminus7;
        this.tminus8 = tminus8;
        this.tminus9 = tminus9;
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

    public double getT0() {
        return t0;
    }

    public void setT0(double t0) {
        this.t0 = t0;
    }

    public double getTminus1() {
        return tminus1;
    }

    public void setTminus1(double tminus1) {
        this.tminus1 = tminus1;
    }

    public double getTminus2() {
        return tminus2;
    }

    public void setTminus2(double tminus2) {
        this.tminus2 = tminus2;
    }

    public double getTminus3() {
        return tminus3;
    }

    public void setTminus3(double tminus3) {
        this.tminus3 = tminus3;
    }

    public double getTminus4() {
        return tminus4;
    }

    public void setTminus4(double tminus4) {
        this.tminus4 = tminus4;
    }

    public double getTminus5() {
        return tminus5;
    }

    public void setTminus5(double tminus5) {
        this.tminus5 = tminus5;
    }

    public double getTminus6() {
        return tminus6;
    }

    public void setTminus6(double tminus6) {
        this.tminus6 = tminus6;
    }

    public double getTminus7() {
        return tminus7;
    }

    public void setTminus7(double tminus7) {
        this.tminus7 = tminus7;
    }

    public double getTminus8() {
        return tminus8;
    }

    public void setTminus8(double tminus8) {
        this.tminus8 = tminus8;
    }

    public double getTminus9() {
        return tminus9;
    }

    public void setTminus9(double tminus9) {
        this.tminus9 = tminus9;
    }


}

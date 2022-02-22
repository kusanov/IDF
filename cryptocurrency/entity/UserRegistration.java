package com.idfin.kusanov.cryptocurrency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration")
public class UserRegistration {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "registration_price")
    private double registrationPrice;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getRegistrationPrice() {
        return registrationPrice;
    }

    public void setRegistrationPrice(double pricecur) {
        this.registrationPrice = pricecur;
    }

    public UserRegistration() {
    }

    public UserRegistration(String username, String symbol, double registrationPrice) {
        this.username = username;
        this.symbol = symbol;
        this.registrationPrice = registrationPrice;
    }
}

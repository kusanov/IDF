package com.idfin.kusanov.cryptocurrency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "symbol")
    private String symbol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Currency() {
    }

    public Currency(int id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }
}

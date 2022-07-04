package com.crypto.recommendation.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CRYPTO")
public class Crypto {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Enumerated(EnumType.STRING)
    @Column(name = "SYMBOL")
    private Symbol symbol;

    public Crypto() {
    }

    public Crypto(int id, Date timestamp, Symbol symbol, Double price) {
        this.id = id;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.price = price;
    }

    @Column(name = "PRICE")
    private Double price;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}


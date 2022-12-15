package com.kata.account.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String amountChange;
    private Long timestamp;

    private Long currentBalance;



    public History(){

    }

    public History(String amountChange,Long timestamp,Long currentBalance){
        this.timestamp = timestamp;
        this.amountChange = amountChange;
        this.currentBalance = currentBalance;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(String amountChange) {
        this.amountChange = amountChange;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }
}

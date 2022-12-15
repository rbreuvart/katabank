package com.kata.account.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity()
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long totalAmount;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "history_id")
    private Set<History> history = new HashSet<>();

    public Client() {
        this.totalAmount = 0L;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<History> getHistory() {
        return history;
    }

    public void setHistory(Set<History> historys) {
        this.history = historys;
    }
}

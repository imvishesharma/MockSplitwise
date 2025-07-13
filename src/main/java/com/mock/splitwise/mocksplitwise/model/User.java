package com.mock.splitwise.mocksplitwise.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Column(unique = true)
    private final String name;
    @Id
    private final Integer id;
    @Embedded
    private BalanceSheet balances;

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
        balances = new BalanceSheet();
    }

    public User() {
        name = null;
        id = -1;
        balances = new BalanceSheet();
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public BalanceSheet getBalances() {
        return balances;
    }
}

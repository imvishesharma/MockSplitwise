package com.mock.splitwise.mocksplitwise.model;

import com.mock.splitwise.mocksplitwise.DebtMapConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;

import java.util.HashMap;

@Embeddable
public class BalanceSheet {
    private Integer totalBalance;

    @Convert(converter = DebtMapConverter.class)
    private HashMap<User, Integer> debts;

    public BalanceSheet() {
        totalBalance = 0;
        debts = new HashMap<>();
    }

    public Integer getTotalBalance() {
        return totalBalance;
    }

    public HashMap<User, Integer> getDebts() {
        return debts;
    }

    public void addDebt(User user, int debt) {
        totalBalance += debt;
        debts.put(user, debt+debts.getOrDefault(user, 0));
    }
}

package com.mock.splitwise.mocksplitwise.services;

import com.mock.splitwise.mocksplitwise.model.BalanceSheet;
import com.mock.splitwise.mocksplitwise.model.User;

public class ExpenseManager {

    public ExpenseManager() {

    }

    public void addExpense(User lender, User borrower, int amount) {
        BalanceSheet balanceSheet = lender.getBalances();
        balanceSheet.addDebt(borrower, amount);

        balanceSheet = borrower.getBalances();
        balanceSheet.addDebt(lender, -amount);
    }
}

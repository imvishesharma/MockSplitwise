package com.mock.splitwise.mocksplitwise.services;

import com.mock.splitwise.mocksplitwise.model.BalanceSheet;
import com.mock.splitwise.mocksplitwise.model.User;
import com.mock.splitwise.mocksplitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExpenseManager {

    @Autowired
    private UserRepository userRepository;

    public ExpenseManager() {

    }

    public void addExpense(String lender, String borrower, int amount) {
        List<User> users = userRepository.findAll();
        Optional<User> userOptionalA = users.stream().filter(u -> Objects.equals(u.getName(), lender)).findFirst();
        Optional<User> userOptionalB = users.stream().filter(u -> Objects.equals(u.getName(), borrower)).findFirst();

        if (userOptionalA.isPresent() && userOptionalB.isPresent()) {
            User a = userOptionalA.get();
            User b = userOptionalB.get();
            a.getBalances().addDebt(b, amount);
            b.getBalances().addDebt(a, -amount);
            userRepository.save(a);
            userRepository.save(b);
        }
    }
}

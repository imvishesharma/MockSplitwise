package com.mock.splitwise.mocksplitwise.controller;

import com.mock.splitwise.mocksplitwise.model.User;
import com.mock.splitwise.mocksplitwise.services.ExpenseManager;
import com.mock.splitwise.mocksplitwise.services.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestSplitwiseController {

    @Autowired
    private UserManager userManager;
    @Autowired
    private ExpenseManager expenseManager;

    @GetMapping("/home/{user}/add")
    public ResponseEntity<?> addExpense(
            @PathVariable String user,
            @RequestParam String borrower,
            @RequestParam Integer expense) {

        // Your search logic here
        expenseManager.addExpense(user, borrower, expense);
        return ResponseEntity.ok("addExpense: " + user + ", borrower: " + borrower + ", expense: " + expense);
    }

    @GetMapping("/home/{username}")
    public User showUserDetails(
            @PathVariable String username) {

        userManager.addUser(username);
        return userManager.getUser(username);
    }

    @GetMapping("/home")
    public List<User> getAllUsers() {
        return userManager.getAllUsers();
    }
}

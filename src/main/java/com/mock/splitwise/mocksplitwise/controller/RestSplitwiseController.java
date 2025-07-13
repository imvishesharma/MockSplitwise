package com.mock.splitwise.mocksplitwise.controller;

import com.mock.splitwise.mocksplitwise.model.User;
import com.mock.splitwise.mocksplitwise.services.ExpenseManager;
import com.mock.splitwise.mocksplitwise.services.UserManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RestSplitwiseController {

    private UserManager userManager = new UserManager();
    private ExpenseManager expenseManager = new ExpenseManager();

    @GetMapping("/home/{user}/add")
    public ResponseEntity<?> addExpense(
            @PathVariable String user,
            @RequestParam String borrower,
            @RequestParam Integer expense) {

        // Your search logic here
        expenseManager.addExpense(userManager.getUser(user), userManager.getUser(borrower), expense);
        return ResponseEntity.ok("addExpense: " + user + ", borrower: " + borrower + ", expense: " + expense);
    }

    @GetMapping("/home/{username}")
    public User showUserDetails(
            @PathVariable String username) {

        userManager.addUser(username);
        return userManager.getUser(username);
    }

    @GetMapping("/home")
    public HashMap<String, User> getAllUsers() {
        return userManager.getAllUsers();
    }
}

package com.mock.splitwise.mocksplitwise.services;

import com.mock.splitwise.mocksplitwise.model.User;
import com.mock.splitwise.mocksplitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserManager {
    private static int id = 1;
    private HashMap<String, User> userMap;

    @Autowired
    private UserRepository userRepository;

    public UserManager() {
        userMap = new HashMap<>();
    }

    public void addUser(String username) {
        if (!userMap.containsKey(username)) {
            User user = new User(username, id++);
            userMap.put(username, user);
        }
    }

    public User getUser(String username) {
        return userMap.get(username);
    }

    public HashMap<String, User> getAllUsers() {
        return userMap;
    }
}

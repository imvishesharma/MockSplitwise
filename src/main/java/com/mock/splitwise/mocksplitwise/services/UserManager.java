package com.mock.splitwise.mocksplitwise.services;

import com.mock.splitwise.mocksplitwise.model.User;
import com.mock.splitwise.mocksplitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserManager {
    private static int id = 1;
//    private HashMap<String, User> userMap;

    @Autowired
    private UserRepository userRepository;

    public UserManager() {
//        userMap = new HashMap<>();
    }

    public void addUser(String username) {
        List<User> users = userRepository.findAll();
        Optional<User> optionalUser = users.stream()
                .filter(u -> u.getName().equals(username))
                .findFirst();
        if (optionalUser.isEmpty()) {
            User user = new User(username, id++);
            userRepository.save(user);
        }
    }

    public User getUser(String username) {
        List<User> users = userRepository.findAll();
        Optional<User> optionalUser = users.stream()
                .filter(u -> u.getName().equals(username))
                .findFirst();
        if (optionalUser.isPresent()) {
            optionalUser.get();
        }
        return new User(username, -1);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

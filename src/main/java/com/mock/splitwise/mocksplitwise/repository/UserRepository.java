package com.mock.splitwise.mocksplitwise.repository;

import com.mock.splitwise.mocksplitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}

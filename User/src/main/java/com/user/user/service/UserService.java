package com.user.user.service;

import com.user.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getUserByUsername(String username);
    User getUserById(Long id);
    List<User> getAllUsers();
}

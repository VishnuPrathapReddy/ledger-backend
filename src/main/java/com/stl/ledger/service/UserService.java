package com.stl.ledger.service;

import java.util.List;

import com.stl.ledger.models.User;

public interface UserService {

    User registerUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByEmail(String email);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}

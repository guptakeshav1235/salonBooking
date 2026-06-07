package com.keshav.services;

import java.util.List;

import com.keshav.model.user;

public interface userService {
    user createUser(user user);
    user getUserById(long id);
    List<user> getAllUsers();
    void deleteUser(Long id);
    user updateUser(Long id, user user);
    
}

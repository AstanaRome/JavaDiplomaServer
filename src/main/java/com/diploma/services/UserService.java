package com.diploma.services;

import com.diploma.models.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    List<User> getAllUsers();

}

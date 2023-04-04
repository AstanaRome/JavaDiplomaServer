package com.diploma.services.impl;

import com.diploma.models.User;
import com.diploma.repository.UserRepository;
import com.diploma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser (User user){
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String testPasswordEncoded = passwordEncoder.encode(password);
        user.setPassword(testPasswordEncoded);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

package com.diploma.rest_controllers;

import com.diploma.models.User;
import com.diploma.repository.UserRepository;
import com.diploma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers(User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User test = userRepository.getUserByUsername(auth.getName());
        System.out.println(test.getId());
        return userService.getAllUsers();
    }


}

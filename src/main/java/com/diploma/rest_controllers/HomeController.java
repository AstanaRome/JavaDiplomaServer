package com.diploma.rest_controllers;

import com.diploma.models.Role;
import com.diploma.models.User;
import com.diploma.repository.UserRepository;
import com.diploma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;

    public HomeController(UserService userService) {
        super();
        this.userService = userService;
    }
    @GetMapping
    public String getHome() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        System.out.println(user.getRole_id());
        String temp = "";
        return "succesfull" + user.getRole_id().getName();
    }

    @GetMapping("/info")
    public User getMyInfo() {
        return userService.getMyInfo();
    }
}

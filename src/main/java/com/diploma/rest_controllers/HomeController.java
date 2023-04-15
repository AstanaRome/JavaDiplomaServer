package com.diploma.rest_controllers;

import com.diploma.models.Role;
import com.diploma.models.User;
import com.diploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    UserRepository userRepository;

    @GetMapping
    public String getHome() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User test = userRepository.getUserByUsername(auth.getName());
        System.out.println(test.getRoles());
        String temp = "";
        for (Role role : test.getRoles()) {

        }
        return "succesfull" +;
    }
}

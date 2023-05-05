package com.diploma.rest_controllers;

import com.diploma.models.Role;
import com.diploma.models.User;
import com.diploma.models.UserForm;
import com.diploma.repository.UserRepository;
import com.diploma.services.RecordService;
import com.diploma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    public HomeController(UserService userService) {
        super();
        this.userService = userService;
    }
    @GetMapping
    public String getHome() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        System.out.println(user.getRole_id());
        return "succesfull" + user.getRole_id().getName();
    }

    @GetMapping("/info")
    public User getInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        System.out.println("ok");
        return user;
    }

    @PostMapping("change_user")
    public String changeUser(@RequestBody UserForm userForm) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        if (user.getId() == userForm.getUser().getId()){
            if (userForm.getChangeColumn().equals("password")){
                String password = userForm.getUser().getPassword();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String testPasswordEncoded = passwordEncoder.encode(password);
                user.setPassword(testPasswordEncoded);
            }
            else if (userForm.getChangeColumn().equals("birthdate")){
                user.setBirthDate(userForm.getUser().getBirthDate());
            }
            else if (userForm.getChangeColumn().equals("email")){
                user.setEmail(userForm.getUser().getEmail());
            }
            System.out.println(userForm.getChangeColumn().toString());
            userRepository.save(user);
            return "succesfull";
        }
        return "fail";
    }


}

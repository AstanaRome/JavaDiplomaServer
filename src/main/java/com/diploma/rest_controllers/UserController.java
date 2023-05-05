package com.diploma.rest_controllers;

import com.diploma.exception.ValidationException;
import com.diploma.models.User;
import com.diploma.services.DoctorUserService;
import com.diploma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/users")
public class UserController extends  BaseControllerImpl<User, UserService>{
    protected UserController(UserService userService){
        super(userService);
    }
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    ResponseEntity<?> addUser( @RequestBody  User user)  throws ValidationException {
        userService.saveOrUpdate(user);
        System.out.println("adduser");
        return ResponseEntity.ok("User is valid");
    }

//    private UserService userService;
//    @Autowired
//    private UserRepository userRepository;
//    public UserController(UserService userService) {
//        super();
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<User> saveUser(@RequestBody User user) {
//        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public List<User> getAllUsers(User user) {
//        return userService.getAllUsers();
//    }
//
//
//
//    @GetMapping("/{id}")
//    public User getById(@PathVariable int id) {
//        return userService.getById(id);
//    }



}

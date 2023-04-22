package com.diploma.rest_controllers;

import com.diploma.models.User;
import com.diploma.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends  BaseControllerImpl<User, UserService>{
    protected UserController(UserService userService){
        super(userService);
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

package com.diploma.rest_controllers;

import com.diploma.models.Doctor;
import com.diploma.models.Record;
import com.diploma.repository.RecordRepository;
import com.diploma.repository.UserRepository;
import com.diploma.services.DoctorService;
import com.diploma.services.RecordService;
import com.diploma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController extends BaseControllerImpl<Record, RecordService> {

    @Autowired
    private RecordService service;

    protected RecordController(RecordService recordService) {
        super(recordService);
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

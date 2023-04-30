package com.diploma.rest_controllers;

import com.diploma.models.Doctor;
import com.diploma.models.Record;
import com.diploma.models.Visit;
import com.diploma.repository.UserRepository;
import com.diploma.services.ClientService;
import com.diploma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    public ClientController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }

    @GetMapping("/free")
    public List<Record> getAllFreeRecords() {
        return clientService.getAllFreeRecords();
    }

    @PutMapping("/free")
    public Record setRecord(@RequestBody Record record) {
        return clientService.setFreeRecord(record);
    }

    @GetMapping("/my_records")
    public List<Record> myRecords() {
        return clientService.myRecords();
    }

    @GetMapping("/my_visits")
    public List<Visit> myVisits() {
        return clientService.myVisits();
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return clientService.getAllDoctors();
    }


}

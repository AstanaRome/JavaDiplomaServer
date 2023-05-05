package com.diploma.rest_controllers;

import com.diploma.models.Doctor;
import com.diploma.models.Record;
import com.diploma.models.Visit;
import com.diploma.services.ClientService;
import com.diploma.services.DoctorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorUserController {
    @Autowired
    private DoctorUserService doctorUserService;
    public DoctorUserController(DoctorUserService doctorUserService) {
        super();
        this.doctorUserService = doctorUserService;
    }

    @GetMapping ("/free")
    public List<Record> getAllFreeRecords() {
        return doctorUserService.getAllFreeRecords();
    }

    @PostMapping("/free")
    public Record addRecord(@RequestBody  Record record) {
        return doctorUserService.addRecord(record);

    }


    @GetMapping("/book")
    public List<Record> getAllBookRecords() {
        return doctorUserService.getAllBookRecords();
    }
    @GetMapping("/visit")
    public List<Visit> getAllVisits() {
        return doctorUserService.getAllVisits();
    }

    @PostMapping("/visit")
    public Visit addVisit(@RequestBody Visit visit) {
        return doctorUserService.addVisit(visit);
    }

}

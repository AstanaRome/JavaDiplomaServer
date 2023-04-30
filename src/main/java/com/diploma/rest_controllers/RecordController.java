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
    protected RecordController(RecordService recordService) {
        super(recordService);
    }
}

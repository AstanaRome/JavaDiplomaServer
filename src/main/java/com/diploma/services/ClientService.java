package com.diploma.services;

import com.diploma.models.Doctor;
import com.diploma.models.Record;
import com.diploma.models.User;
import com.diploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {
    public ClientService() {}

    @Autowired
    private RecordService recordService;


    public List<Record> getAllFreeRecords() {
        return recordService.getAllFree();
    }


    public Record setFreeRecord(Record record) {
        return recordService.setFreeRecord(record);
    }

    public List <Record> myRecords() {
        return recordService.myRecords();
    }

}

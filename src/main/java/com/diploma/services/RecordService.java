package com.diploma.services;

import com.diploma.models.Doctor;
import com.diploma.models.Record;
import com.diploma.models.User;
import com.diploma.repository.RecordRepository;
import com.diploma.repository.UserRepository;
import com.diploma.services.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService extends BaseServiceImpl<Record, RecordRepository> {
    public RecordService(RecordRepository repository) {
        super(repository);
    }
    @Autowired
    UserRepository userRepository;
    @Transactional
    public List<Record> getAllFree() {
        List<Record> records = repository.getAllFreeRecords();
        for (Record record: records) {
            record.getDoctor().getUser().setPassword("");
        }
        return records;
    }




}

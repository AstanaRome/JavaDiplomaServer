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
    @Transactional
    public Record setFreeRecord(Record record) {
        Record temp = repository.findById(record.getId()).orElse(null);
        if (temp != null && temp.getUser() == null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userRepository.getUserByUsername(auth.getName());
            temp.setUser(user);
            System.out.println("ok");
            System.out.println(temp);
            return repository.save(temp);
        }
        System.out.println("fail");
        return null;
    }


    @Transactional
    public List <Record> myRecords() {

        List <Record> records2 = new ArrayList<>();
        List <Record> records = repository.findAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        for (Record record: records) {
            if (record.getUser()!= null){
                if (user.getId() == record.getUser().getId()){
                    Record record_temp = record;
                    record_temp.getDoctor().getUser().setPassword("");
                    records2.add(record_temp);
                }
            }

        }
        System.out.println(records2.size());
        return records2;
    }
}

package com.diploma.services;

import com.diploma.models.Doctor;
import com.diploma.models.Record;
import com.diploma.models.User;
import com.diploma.models.Visit;
import com.diploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorUserService {
    public DoctorUserService() {}
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RecordService recordService;
    @Autowired
    private VisitService visitService;

    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;

//    public Record setFreeRecord(Record record) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userRepository.getUserByUsername(auth.getName());
//        Record temp = recordService.getById(record.getId());
//        if (temp != null && temp.getDoctor().getId() == user.getId()){
//
//            temp.setUser(record.getUser());
//            return recordService.saveOrUpdate(temp);
//        }
//        System.out.println("fail");
//        return null;
//    }

    public List<Record> getAllFreeRecords() {

        List<Record> records = recordService.getAll();
        List<Record> records2 = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        for (Record record: records ) {
            if(record.getDoctor().getUser().getId() == user.getId()){
                if (record.getUser() == null){
                    records2.add(record);
                }
            }
        }
        return records2;
    }

    public List<Record> getAllBookRecords() {
        System.out.println("book");
        List<Record> records = recordService.getAll();
        List<Record> records2 = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        for (Record record: records ) {
            if(record.getDoctor().getId() == user.getId()){
                if (record.getUser() != null){
                    record.getUser().setPassword("");
                    records2.add(record);
                }
            }
        }
        return records2;
    }

    public Record addRecord(Record record) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        System.out.println(record.toString());
        record.setDoctor(doctorService.getByUserId(user.getId()));
        return recordService.saveOrUpdate(record);
    }


    public List<Visit> getAllVisits() {

        List<Visit> visits = visitService.getAll();
        List<Visit> visits2 = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        for (Visit visit: visits ) {
            if(visit.getDoctor().getId() == user.getId()){
                    visit.getUser().setPassword("");
                    visits2.add(visit);

            }
        }
        return visits2;
    }


}

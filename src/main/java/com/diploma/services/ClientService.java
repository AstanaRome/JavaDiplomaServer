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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    public ClientService() {}
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RecordService recordService;
    @Autowired
    private VisitService visitService;

    @Autowired
    private DoctorService doctorService;

    public List<Record> getAllFreeRecords() {
        return recordService.getAllFree();
    }


    public Record setFreeRecord(Record record) {
        return recordService.setFreeRecord(record);
    }

    public List <Record> myRecords() {
        return recordService.myRecords();
    }

    public List <Visit> myVisits() {
        List<Visit> visits = visitService.getAll();
        List<Visit> visits2 = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        for (Visit visit: visits ) {
            if (visit.getUser() != null){
                if (visit.getUser().getId() == user.getId()){
                    visits2.add(visit);
                }
            }

        }
        return visits2;
    }


    public List <Doctor> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAll();
//        List<Doctor> doctors2 = new ArrayList<>();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userRepository.getUserByUsername(auth.getName());
//        for (Doctor doctor: doctors ) {
//            doctor.getUser().setPassword("");
//        }
        return doctors;
    }

}

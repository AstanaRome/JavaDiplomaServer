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
            Record temp = recordService.getById(record.getId());
            if (temp != null && temp.getUser() == null){
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                User user = userRepository.getUserByUsername(auth.getName());
                temp.setUser(user);
                return recordService.saveOrUpdate(temp);
            }
            System.out.println("fail");
            return null;
        }


    public List <Record> myRecords() {
            List <Record> records2 = new ArrayList<>();
            List <Record> records = recordService.getAll();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userRepository.getUserByUsername(auth.getName());
            for (Record record: records) {
                if (record.getUser()!= null){
                    if (user.getId() == record.getUser().getId()){
                        System.out.println(record.getDoctor().getUser().getPassword());
                        record.getDoctor().getUser().setPassword("");
                        records2.add(record);
                    }
                }

            }
            return records2;

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
        List<Doctor> doctors2 = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.getUserByUsername(auth.getName());
        for (Doctor doctor: doctors ) {
            doctor.getUser().setPassword("");
        }
        return doctors;
    }

}

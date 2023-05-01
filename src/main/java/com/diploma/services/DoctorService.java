package com.diploma.services;

import com.diploma.models.Doctor;
import com.diploma.models.Role;
import com.diploma.repository.DoctorRepository;
import com.diploma.repository.RoleRepository;
import com.diploma.services.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService extends BaseServiceImpl<Doctor, DoctorRepository> {
    public DoctorService(DoctorRepository repository) {
        super(repository);
    }

    public  Doctor  getByUserId(int userid){
        List<Doctor> doctors = repository.findAll();
        for (Doctor doctor: doctors) {
            if (doctor.getUser().getId() == userid){
                return doctor;
            }
        }
        return null;
    }

}

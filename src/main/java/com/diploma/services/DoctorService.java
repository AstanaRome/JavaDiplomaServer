package com.diploma.services;

import com.diploma.models.Doctor;
import com.diploma.models.Role;
import com.diploma.repository.DoctorRepository;
import com.diploma.repository.RoleRepository;
import com.diploma.services.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseServiceImpl<Doctor, DoctorRepository> {
    public DoctorService(DoctorRepository repository) {
        super(repository);
    }
}

package com.diploma.services;

import com.diploma.models.Role;
import com.diploma.models.Visit;
import com.diploma.repository.RoleRepository;
import com.diploma.repository.VisitRepository;
import com.diploma.services.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class VisitService extends BaseServiceImpl<Visit, VisitRepository> {
    public VisitService(VisitRepository repository) {
        super(repository);
    }
}

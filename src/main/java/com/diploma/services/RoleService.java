package com.diploma.services;

import com.diploma.models.Role;
import com.diploma.repository.RoleRepository;
import com.diploma.services.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseServiceImpl<Role, RoleRepository> {
    public RoleService(RoleRepository repository) {
        super(repository);
    }
}

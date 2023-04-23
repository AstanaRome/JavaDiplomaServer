package com.diploma.rest_controllers;

import com.diploma.models.Role;
import com.diploma.models.User;
import com.diploma.services.BaseService;
import com.diploma.services.RoleService;
import com.diploma.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController  extends  BaseControllerImpl<Role, RoleService>{
    protected RoleController(RoleService roleService){
        super(roleService);
    }
}

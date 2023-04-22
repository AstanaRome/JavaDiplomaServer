package com.diploma.rest_controllers;


import com.diploma.models.BaseEntity;
import com.diploma.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class BaseControllerImpl<T extends BaseEntity, S extends BaseService<T>> implements BaseController<T> {

    private final S service;


    @Autowired
    protected BaseControllerImpl(S service) {
        this.service = service;
    }

    @Override
    public List<T> getAll()

    {
        System.out.println("test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return service.getAll();
    }

    @Override
    public T getById(@PathVariable int id) {
        return service.getById(id);
    }

    @Override
    public T add(@RequestBody T entity) {
        return service.saveOrUpdate(entity);
    }

    @Override
    public T update(@RequestBody T entity) {
        return service.saveOrUpdate(entity);
    }

    @Override
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}

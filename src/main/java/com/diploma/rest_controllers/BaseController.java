package com.diploma.rest_controllers;

import com.diploma.models.BaseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface BaseController<T extends BaseEntity>{

    @GetMapping
    List<T> getAll();

    @GetMapping("/{id}")
    T getById(@PathVariable int id);

    @PostMapping
    T add(@RequestBody  T entity);

    @PutMapping
    T update(@RequestBody  T entity);

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id);
}

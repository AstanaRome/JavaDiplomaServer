package com.diploma.services;


import com.diploma.models.BaseEntity;
import com.diploma.models.User;

import java.util.List;

public interface BaseService<T extends BaseEntity>{
    List<T> getAll();
    T getById(int id);
    T saveOrUpdate(T entity);
    void deleteById(int id);

}

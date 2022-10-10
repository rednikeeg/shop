package com.rednikeeg.shop.service;

import com.rednikeeg.shop.domain.Item;

import java.util.List;

public interface CrudService<ID, T> {
    List<T> getAll();

    T getById(ID id);

    T deleteById(ID id);

    T save(T entity);

    T update(T entity);
}

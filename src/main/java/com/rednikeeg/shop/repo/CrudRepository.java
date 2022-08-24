package com.rednikeeg.shop.repo;

import com.rednikeeg.shop.domain.Entity;

import java.util.List;

public interface CrudRepository<ID, T extends Entity<ID>> {
    List<T> getAll();

    T save(T entity);

    T getById(ID id);

    T update(T entity);

    T deleteById(ID id);
}

package com.rednikeeg.shop.service;

import com.rednikeeg.shop.domain.Category;
import com.rednikeeg.shop.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CrudService<Long, Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category deleteById(Long id) {
        return categoryRepository.deleteById(id);
    }

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        return categoryRepository.update(entity);
    }
}

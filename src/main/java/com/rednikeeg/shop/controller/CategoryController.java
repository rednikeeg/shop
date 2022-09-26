package com.rednikeeg.shop.controller;

import com.rednikeeg.shop.dto.CategoryDto;
import com.rednikeeg.shop.service.CategoryService;
import com.rednikeeg.shop.util.CategoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryTransformer categoryTransformer;

    @GetMapping(path = "/get/all")
    @ResponseBody
    public List<CategoryDto> getAll() {
        return categoryService.getAll()
                .stream()
                .map(categoryTransformer::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public CategoryDto save(@RequestBody CategoryDto category) {
        return Optional.of(category)
                .map(categoryTransformer::toEntity)
                .map(categoryService::save)
                .map(categoryTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category " + category + "cannot be saved."));
    }

    @GetMapping(path = "/getById/:{id}")
    @ResponseBody
    public CategoryDto getById(@PathVariable Long id) {
        return Optional.of(id)
                .map(categoryService::getById)
                .map(categoryTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " cannot be found."));
    }

    @PutMapping(path = "/update")
    @ResponseBody
    public CategoryDto update(@RequestBody CategoryDto category) {
        return Optional.of(category)
                .map(categoryTransformer::toEntity)
                .map(categoryService::update)
                .map(categoryTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category " + category + " cannot be updated."));
    }

    @DeleteMapping(path = "/delete/:{id}")
    @ResponseBody
    public CategoryDto deleteById(@PathVariable Long id) {
        return Optional.of(id)
                .map(categoryService::deleteById)
                .map(categoryTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " cannot be deleted."));
    }
}

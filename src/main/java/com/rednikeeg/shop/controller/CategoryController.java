package com.rednikeeg.shop.controller;

import com.rednikeeg.shop.dto.CategoryDto;
import com.rednikeeg.shop.service.CategoryService;
import com.rednikeeg.shop.util.CategoryTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping(path = "/api/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryTransformer categoryTransformer;

    @PostMapping
    @ResponseBody
    public CategoryDto save(@RequestBody CategoryDto category) {
        return Optional.of(category)
                .map(categoryTransformer::toEntity)
                .map(categoryService::save)
                .map(categoryTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category " + category + " cannot be saved."));
    }

    @GetMapping
    @ResponseBody
    public List<CategoryDto> getAll() {
        return categoryService.getAll()
                .stream()
                .map(categoryTransformer::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/:{id}")
    @ResponseBody
    public CategoryDto getById(@PathVariable Long id) {
        return Optional.of(id)
                .map(categoryService::getById)
                .map(categoryTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " cannot be found."));
    }

    @PutMapping(path = "/:{id}")
    @ResponseBody
    public CategoryDto update(@PathVariable Long id, @RequestBody CategoryDto category) {
        return Optional.of(category)
                .map(categoryTransformer::toEntity)
                .map(categoryService::update)
                .map(categoryTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category " + category + " cannot be updated."));
    }

    @DeleteMapping(path = "/:{id}")
    @ResponseBody
    public CategoryDto delete(@PathVariable Long id) {
        return Optional.of(id)
                .map(categoryService::deleteById)
                .map(categoryTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " cannot be deleted."));
    }
}

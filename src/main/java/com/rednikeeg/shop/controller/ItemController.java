package com.rednikeeg.shop.controller;

import com.rednikeeg.shop.dto.ItemDto;
import com.rednikeeg.shop.service.ItemService;
import com.rednikeeg.shop.util.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/api/1.0/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemTransformer itemTransformer;

    @GetMapping
    @ResponseBody
    public List<ItemDto> getAll() {
        return itemService.getAll()
                .stream()
                .map(itemTransformer::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseBody
    public ItemDto save(ItemDto item) {
        return Optional.of(item)
                .map(itemTransformer::toEntity)
                .map(itemService::save)
                .map(itemTransformer::toDto)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Item " + item + " cannot be saved.");
                });
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ItemDto get(@PathVariable Long id) {
        return Optional.of(id)
                .map(itemService::getById)
                .map(itemTransformer::toDto)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Item with id " + id + " cannot be found.");
                });
    }

    @PutMapping
    @ResponseBody
    public ItemDto update(ItemDto item) {
        return Optional.of(item)
                .map(itemTransformer::toEntity)
                .map(itemService::update)
                .map(itemTransformer::toDto)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Item " + item + " cannot be updated.");
                });
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public ItemDto delete(@PathVariable Long id) {
        return Optional.of(id)
                .map(itemService::deleteById)
                .map(itemTransformer::toDto)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Item with id " + id + " cannot be deleted.");
                });
    }
}

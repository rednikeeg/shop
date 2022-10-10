package com.rednikeeg.shop.controller;

import com.rednikeeg.shop.dto.ItemDto;
import com.rednikeeg.shop.service.ItemService;
import com.rednikeeg.shop.util.ItemTransformer;
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
@RequestMapping(path = "/api/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {
    private final ItemService itemService;
    private final ItemTransformer itemTransformer;

    @PostMapping
    @ResponseBody
    public ItemDto save(@RequestBody ItemDto item) {
        return Optional.of(item)
                .map(itemTransformer::toEntity)
                .map(itemService::save)
                .map(itemTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Item " + item + " cannot be saved."));
    }

    @GetMapping
    @ResponseBody
    public List<ItemDto> getAll() {
        return itemService.getAll()
                .stream()
                .map(itemTransformer::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/:{id}")
    @ResponseBody
    public ItemDto getById(@PathVariable Long id) {
        return Optional.of(id)
                .map(itemService::getById)
                .map(itemTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Item with id " + id + " cannot be found."));
    }

    @PutMapping(path = "/:{id}")
    @ResponseBody
    public ItemDto update(@PathVariable Long id, @RequestBody ItemDto item) {
        return Optional.of(formUpdatedItem(id, item))
                .map(itemTransformer::toEntity)
                .map(itemService::update)
                .map(itemTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Item " + item + " cannot be updated."));
    }

    @DeleteMapping(path = "/:{id}")
    @ResponseBody
    public ItemDto delete(@PathVariable Long id) {
        return Optional.of(id)
                .map(itemService::deleteById)
                .map(itemTransformer::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Item with id " + id + " cannot be deleted."));
    }

    private ItemDto formUpdatedItem(Long id, ItemDto item) {
        return getById(id)
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setCategory(item.getCategory())
                .setQuantity(item.getQuantity());
    }
}

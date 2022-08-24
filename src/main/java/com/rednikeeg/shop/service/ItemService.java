package com.rednikeeg.shop.service;

import com.rednikeeg.shop.domain.Item;
import com.rednikeeg.shop.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService implements CrudService<Long, Item> {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getByCategoryId(Long categoryId) {
        return getAll()
                .stream()
                .filter(item -> item.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.getAll();
    }

    @Override
    public Item getById(Long id) {
        return (itemRepository.getById(id));
    }

    @Override
    public Item deleteById(Long id) {
        return itemRepository.deleteById(id);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.update(item);
    }
}

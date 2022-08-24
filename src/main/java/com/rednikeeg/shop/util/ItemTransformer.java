package com.rednikeeg.shop.util;

import com.rednikeeg.shop.domain.Item;
import com.rednikeeg.shop.dto.CategoryDto;
import com.rednikeeg.shop.dto.ItemDto;
import com.rednikeeg.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ItemTransformer {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryTransformer categoryTransformer;

    public ItemDto toDto(Item entity) {
        return ItemDto.builder()
                .id(entity.getId())
                .category(resolveCategory(entity.getCategoryId()))
                .name(entity.getName())
                .description(entity.getDescription())
                .quantity(entity.getQuantity())
                .build();
    }

    public Item toEntity(ItemDto dto) {
        return Item.builder()
                .id(dto.getId())
                .categoryId(dto.getCategory().getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .quantity(dto.getQuantity())
                .build();
    }

    private CategoryDto resolveCategory(Long id) {
        return Optional.ofNullable(categoryService.getById(id))
                .map(categoryTransformer::toDto)
                .orElseThrow(IllegalStateException::new);
    }
}
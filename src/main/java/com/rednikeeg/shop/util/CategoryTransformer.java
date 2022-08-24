package com.rednikeeg.shop.util;

import com.rednikeeg.shop.domain.Category;
import com.rednikeeg.shop.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryTransformer {
    public CategoryDto toDto(Category entity) {
        return CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    public Category toEntity(CategoryDto dto) {
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}

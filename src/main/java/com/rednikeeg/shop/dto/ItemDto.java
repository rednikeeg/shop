package com.rednikeeg.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private CategoryDto category;
    private Integer quantity;
}

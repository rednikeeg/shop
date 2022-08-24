package com.rednikeeg.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item implements Entity<Long> {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private Integer quantity;
}

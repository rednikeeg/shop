package com.rednikeeg.shop.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category implements Entity<Long> {
    private Long id;
    private String name;
    private String description;
}

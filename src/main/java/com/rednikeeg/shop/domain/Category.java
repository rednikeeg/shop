package com.rednikeeg.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Entity<Long> {
    private Long id;
    private String name;
    private String description;
}

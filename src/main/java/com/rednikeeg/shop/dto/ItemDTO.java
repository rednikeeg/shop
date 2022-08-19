package com.rednikeeg.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
}

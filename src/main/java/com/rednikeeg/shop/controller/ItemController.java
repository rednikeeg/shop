package com.rednikeeg.shop.controller;

import com.rednikeeg.shop.dto.ItemDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @GetMapping
    @ResponseBody
    public List<ItemDTO> getAll() {
        List<ItemDTO> list = new ArrayList<>();

        list.add(new ItemDTO(1L, "Candy", "This is candy", 3));

        return list;
    }
}

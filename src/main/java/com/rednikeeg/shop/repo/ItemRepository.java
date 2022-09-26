package com.rednikeeg.shop.repo;

import com.rednikeeg.shop.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class ItemRepository extends AbstractCrudRepository<Item> {
    public ItemRepository() {
        content = Arrays.asList(
                new Item(1L, "Chocolate", "This is chocolate", 1L, 5),
                new Item(2L, "Rafaello", "This is rafaello", 1L, 8),
                new Item(3L, "Candy", "This is candy", 1L, 20),
                new Item(4L, "Banana", "This is banana", 2L, 10),
                new Item(5L, "Apple", "This is apple", 2L, 30)
        );
    }
}

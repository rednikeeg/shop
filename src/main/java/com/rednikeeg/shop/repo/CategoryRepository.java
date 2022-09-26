package com.rednikeeg.shop.repo;

import com.rednikeeg.shop.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class CategoryRepository extends AbstractCrudRepository<Category> {
    public CategoryRepository() {
        content = Arrays.asList(
            new Category(1L, "Sweet products", "Candies, chocolate etc."),
            new Category(2L, "Fruits", "Some juicy fruits")
        );
    }
}

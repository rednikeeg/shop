package com.rednikeeg.shop.repo;

import com.rednikeeg.shop.domain.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCrudRepository<T extends Entity<Long>> implements CrudRepository<Long, T> {
    protected List<T> content = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<T> getAll() {
        return new ArrayList<>(content);
    }

    @Override
    public T save(@NotNull T toSave) {
        T saved = null;

        if (toSave.getId() == null) {
            saved = toSave;
            saved.setId(nextId++);
            content.add(saved);
        }

        return saved;
    }

    @Override
    public T getById(@NotNull Long id) {
        return content.stream()
                .filter(item -> id.equals(item.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public T update(@NotNull T toUpdate) {
        if (deleteById(toUpdate.getId()) == null) {
            return null;
        }
        content.add(toUpdate);

        return toUpdate;
    }

    @Override
    public T deleteById(@NotNull Long id) {
        T toDelete = getById(id);

        return toDelete != null && content.remove(toDelete) ?
                toDelete : null;
    }
}

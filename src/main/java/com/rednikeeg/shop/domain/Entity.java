package com.rednikeeg.shop.domain;

public interface Entity<ID> {
    ID getId();
    void setId(ID id);
}

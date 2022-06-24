package com.storage.warehouse.models;

import java.math.BigDecimal;

public interface Item {

    public void setPrice(Double price);

    public Integer getCode();

    public void setCode(Integer code);

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public BigDecimal getPrice();

}
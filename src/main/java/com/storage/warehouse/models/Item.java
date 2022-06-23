package com.storage.warehouse.models;

import java.math.BigDecimal;

public interface Item {

    public void set_price(BigDecimal price);

    public Integer get_code();

    public void set_code(Integer code);

    public String get_name();

    public void set_name(String name);

    public String get_description();

    public void set_description(String description);

}
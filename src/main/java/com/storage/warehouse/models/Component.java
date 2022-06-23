package com.storage.warehouse.models;

import java.math.BigDecimal;
import java.util.List;

public class Component implements Item{

    BigDecimal price;
    Integer code;
    String name;
    String description;
    private List<Composition> compositions;

    public Component(BigDecimal price, Integer code, String name, String description){
        this.price = price;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public void set_price(BigDecimal price){
        price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.price = price;
    };


    public BigDecimal get_price(){
        return this.price;
    };


    public void set_code(Integer code){
        this.code = code;
    };


    public void set_name(String name){
        this.name = name;
    };


    public void set_description(String description){
        this.description = description;
    };


    public Integer get_code(){
        return this.code;
    };


    public String get_name(){
        return this.name;
    };


    public String get_description(){
        return this.description;
    };

    public List<Composition> getCompositions(){
        return this.compositions;
    }

}

package com.storage.warehouse.models;

import java.math.BigDecimal;
import java.util.List;

public class Component implements Item{

    private BigDecimal price;
    private Integer code;
    private String name;
    private String description;
    private List<Composition> compositionsWithThisComponent;

    public Component(BigDecimal price, Integer code, String name, String description, List<Composition> compositionsWithThisComponent){
        set_price(price);
        set_code(code);
        set_name(name);
        set_description(description);
        this.compositionsWithThisComponent = compositionsWithThisComponent;
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

    public List<Composition> getCompositionsWithThisComponent(){
        return this.compositionsWithThisComponent;
    }

    public void add_compositions_it_makes_part(Composition comp){
        this.compositionsWithThisComponent.add(comp);
    }

}

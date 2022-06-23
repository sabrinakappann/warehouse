package com.storage.warehouse.models;

import java.math.BigDecimal;
import java.util.List;

public class Component implements Item{

    private BigDecimal price;
    private Integer code;
    private String name;
    private String description;
    private List<Composition> compositionsWithThisComponent;


    /* WHAT TO DO HERE? If I receive BigDecimal in this constructor, I imagine not being able to parse the parameter
                        from user or db. If I use Double as price type, for this propouse is ok, nut not recomended
                        the parse from double to BigDecimal didn't go very well, so I am receiving the price as String:
                                    Easy to convert to BigDecimal */

    public Component(String price, Integer code, String name, String description ){

        this.price = new BigDecimal(price);;
        this.set_price(price);
        this.set_code(code);
        this.set_name(name);
        this.set_description(description);
        List<Composition> compositionsWithThisComponent;
    }

    public void set_price(String price){

        BigDecimal price2 = new BigDecimal(price); // str -> BigDecimal
        price2 = price2.setScale(2, BigDecimal.ROUND_HALF_UP); // round to .00
        this.price = price2;
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
        return compositionsWithThisComponent;
    }

    public void add_compositions_it_makes_part(Composition comp){
        compositionsWithThisComponent.add(comp);
    }

}

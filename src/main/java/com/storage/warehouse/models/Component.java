package com.storage.warehouse.models;

import com.storage.warehouse.utils.Conversion;

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

    public Component(Double price, Integer code, String name, String description ){
        
        this.setPrice(price);
        this.setCode(code);
        this.setName(name);
        this.setDescription(description);
        List<Composition> compositionsWithThisComponent;
    }

    public void setPrice(Double price){
        this.price = Conversion.doubleToBidDecimal(price);
    };


    public BigDecimal getPrice(){
        return this.price;
    };


    public void setCode(Integer code){
        this.code = code;
    };


    public void setName(String name){
        this.name = name;
    };


    public void setDescription(String description){
        this.description = description;
    };


    public Integer getCode(){
        return this.code;
    };


    public String getName(){
        return this.name;
    };


    public String getDescription(){
        return this.description;
    };

    public List<Composition> getCompositionsWithThisComponent(){
        return compositionsWithThisComponent;
    }

    public void addCompositionsItBelongs(Composition comp){
        compositionsWithThisComponent.add(comp);
    }

}

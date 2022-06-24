package com.storage.warehouse.models;


import java.math.BigDecimal;

public abstract class Item {

    private BigDecimal unitPrice;
    private Integer code;
    private String name;
    private String description;
    private Integer quantity;
    BigDecimal TotalItemPrice;
    private final BigDecimal initialPrice = BigDecimal.valueOf(0.0);
    private final Integer default_quantity = Integer.valueOf(1);

    public Item(BigDecimal unitPrice, Integer code, String name, String description, Integer quantity) {
        // Creates an Item with unit price and quantity setted

        this.unitPrice = unitPrice;
        this.code = code;
        this.name = name;
        this.description = description;
        this.setQuantity(quantity);
    }

    public Item(BigDecimal unitPrice, Integer code, String name, String description){
        // Creates a single Item (quantity=1) with unit price

        this.setUnitPrice(unitPrice);
        this.setCode(code);
        this.setName(name);
        this.setDescription(description);
        this.quantity = default_quantity;
    }

    public Item(Integer code, String name, String description){
        // Creates a single Item (quantity=1) with unit price=0
        this.setUnitPrice(this.initialPrice);
        this.setCode(code);
        this.setName(name);
        this.setDescription(description);
        this.quantity = default_quantity;
    }

    public void setUnitPrice(BigDecimal unitPrice){
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public BigDecimal getTotalItemPrice(){
        return this.getUnitPrice().multiply(BigDecimal.valueOf(this.getQuantity()));
    }

    public Integer getQuantity() {
        return this.quantity;
    }

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

    public void setQuantity(Integer quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.getQuantity() + " unidade(s) de " + getName();
    }
}
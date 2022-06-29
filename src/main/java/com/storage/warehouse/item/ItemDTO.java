package com.storage.warehouse.item;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDTO  implements Serializable {
    private static final Long serialVersionUID = 1L;
    private BigDecimal unitPrice;
    private BigDecimal sellPrice;
    private String name;
    private String description;
    private final BigDecimal initialPrice = BigDecimal.valueOf(0.0);

    public ItemDTO() {
    }

    public ItemDTO(BigDecimal unitPrice, BigDecimal sellPrice, String name, String description) {
        this.unitPrice = unitPrice;
        this.sellPrice = sellPrice;
        this.name = name;
        this.description = description;
    }

    public ItemDTO(Item itemEntity){
        this.description = itemEntity.getDescription();
        this.name = itemEntity.getName();
        this.unitPrice = itemEntity.getUnitPrice();
        this.sellPrice = itemEntity.getSellPrice();
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

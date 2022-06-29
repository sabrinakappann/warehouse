package com.storage.warehouse.item;

import java.math.BigDecimal;

public class ItemCommonAtributes {

    private BigDecimal unitPrice;
    private BigDecimal sellPrice;
    private String name;
    private String description;
    private ItemTypes itemType; // can be null

    public ItemCommonAtributes() {
        this.setUnitPrice(BigDecimal.ZERO);
        this.setSellPrice(BigDecimal.ZERO);
        this.setName("");
        this.setDescription("");
        this.itemType = null;
    }

    public ItemCommonAtributes(String name, String description, ItemTypes itemType) {
        this.setName(name);
        this.setDescription(description);
        this.setItemType(itemType);
        this.setUnitPrice(BigDecimal.ZERO);
        this.setSellPrice(BigDecimal.ZERO);
    }

    public ItemCommonAtributes(BigDecimal unitPrice, BigDecimal sellPrice, String name, String description, ItemTypes itemType) {
        this.unitPrice = unitPrice;
        this.sellPrice = sellPrice;
        this.name = name;
        this.description = description;
        this.itemType = itemType;
    }

    public ItemCommonAtributes(BigDecimal unitPrice, BigDecimal sellPrice, String name, String description) {
        this.unitPrice = unitPrice;
        this.sellPrice = sellPrice;
        this.name = name;
        this.description = description;
        this.itemType = null;

    }

    public ItemTypes getItemType() {
        return itemType;
    }

    public void setItemType(ItemTypes itemType) {
        this.itemType = itemType;
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

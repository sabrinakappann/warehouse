package com.storage.warehouse.item;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDTO  implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private BigDecimal unitPrice;
    private BigDecimal sellPrice;
    private String name;
    private String description;
    private String itemType;
    private final BigDecimal defaultPrice = BigDecimal.valueOf(0.0);

    public ItemDTO(Item itemEntity){
        this.setName(itemEntity.getName());
        this.setDescription(itemEntity.getDescription());
        this.setItemType(itemEntity.getItemType());
        this.setUnitPrice(itemEntity.getUnitPrice());
        this.setSellPrice(itemEntity.getSellPrice());
        this.setId(itemEntity.getId());
    }

    public ItemDTO() {
    }

    public ItemDTO(String name, String description, String itemType) {
        this.setName(name);
        this.setDescription(description);
        this.setItemType(itemType);
        this.setUnitPrice(this.defaultPrice);
        this.setSellPrice(this.defaultPrice);
    }

    public ItemDTO(BigDecimal unitPrice, String name, String description, String itemType) {
        this.setUnitPrice(unitPrice);
        this.setName(name);
        this.setDescription(description);
        this.setItemType(itemType);
        this.setSellPrice(this.defaultPrice);
    }

    public ItemDTO(BigDecimal unitPrice, BigDecimal sellPrice, String name, String description, String itemType) {
        this.setUnitPrice(unitPrice);
        this.setSellPrice(sellPrice);
        this.setName(name);
        this.setDescription(description);
        this.setItemType(itemType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}

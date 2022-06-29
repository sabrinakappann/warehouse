package com.storage.warehouse.item;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDTO  implements Serializable {
    private static final Long serialVersionUID = 1L;
    private ItemCommonAtributes itemAtributes;
    private final BigDecimal initialPrice = BigDecimal.valueOf(0.0);

    public ItemDTO() {
        this.itemAtributes = new ItemCommonAtributes();
    }

    public ItemDTO(BigDecimal unitPrice, BigDecimal sellPrice, String name, String description) {
        this.itemAtributes = new ItemCommonAtributes(unitPrice, sellPrice, name, description);
    }

    public ItemDTO(Item itemEntity){
        this.itemAtributes = new ItemCommonAtributes();
        this.itemAtributes.setDescription(itemEntity.getDescription());
        this.itemAtributes.setName(itemEntity.getName());
        this.itemAtributes.setUnitPrice(itemEntity.getUnitPrice());
        this.itemAtributes.setSellPrice(itemEntity.getSellPrice());
    }


}

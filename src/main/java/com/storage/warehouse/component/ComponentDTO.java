package com.storage.warehouse.component;

import com.storage.warehouse.item.ItemCommonAtributes;
import com.storage.warehouse.item.ItemTypes;

import java.io.Serializable;
import java.math.BigDecimal;

public class ComponentDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private ItemCommonAtributes componentCommonItemAtributes;

    public ComponentDTO() {
        this.componentCommonItemAtributes = new ItemCommonAtributes();
        this.componentCommonItemAtributes.setItemType(ItemTypes.COMPONENT);
    }

    public ComponentDTO(Component ent) {
        this.componentCommonItemAtributes = new ItemCommonAtributes(ent.getUnitPrice(), ent.getSellPrice(), ent.getName(), ent.getDescription(), ItemTypes.COMPONENT);
    }
}

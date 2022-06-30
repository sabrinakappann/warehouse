package com.storage.warehouse.component;
import com.storage.warehouse.item.Item;
import com.storage.warehouse.item.ItemDTO;

import java.io.Serializable;

public class ComponentDTO extends ItemDTO {
    private static final Long serialVersionUID = 1L;

    public ComponentDTO(Component componentEntity) {
        super(componentEntity);
        //this.setItemType("COMPONENT");
    }

 /*   public ComponentDTO() {
        this.componentCommonItemAtributes = new ItemCommonAttributes();
        this.componentCommonItemAtributes.setItemType(ItemTypeEnum.COMPONENT);
    }

    public ComponentDTO(Component ent) {
        this.componentCommonItemAtributes = new ItemCommonAttributes(ent.getUnitPrice(), ent.getSellPrice(), ent.getName(), ent.getDescription(), ItemTypeEnum.COMPONENT);
    }*/
}

package com.storage.warehouse.compositionItemQuantity;

import com.storage.warehouse.composition.Composition;
import com.storage.warehouse.item.Item;

public class CompositionItemQuantityDTO {
    private Composition composition;
    private Item item;
    private Integer quantity;
    private CompositionItemQuantityId id;

    public CompositionItemQuantityDTO(CompositionItemQuantity entity){
        this.composition = entity.getComposition();
        this.item = entity.getItem();
        this.quantity = entity.getQuantity();
        this.id = new CompositionItemQuantityId(composition.getId(), item.getId());
    }

}

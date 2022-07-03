package com.storage.warehouse.compositionItemsQuantities;

import com.storage.warehouse.composition.Composition;
import com.storage.warehouse.item.Item;

import java.io.Serializable;

public class CompositionItemsDTO  implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Composition composition;
    private Item item;
    private Integer quantity;
    private CompositionItemsId id;

    public CompositionItemsDTO() {
    }

    public CompositionItemsDTO(CompositionItems entity){
        this.composition = entity.getComposition();
        this.item = entity.getItem();
        this.quantity = entity.getQuantity();
        this.id = new CompositionItemsId(composition.getId(), item.getId());
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CompositionItemsId getId() {
        return id;
    }

    public void setId(CompositionItemsId id) {
        this.id = id;
    }
}

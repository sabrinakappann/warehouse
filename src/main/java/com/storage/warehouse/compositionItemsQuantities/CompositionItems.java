package com.storage.warehouse.compositionItemsQuantities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.storage.warehouse.composition.Composition;
import com.storage.warehouse.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "composition_item_quantity")
public class CompositionItems {

    /*
    *  validar valores de qtds    *
    * */

    @EmbeddedId // pk = CompositionItemsId class
    CompositionItemsId compositionItemsId;

    @ManyToOne
    @MapsId("compositionId") // @MapsId means that we tie those fields to a part of the key, and they're the
                            // foreign keys of a many-to-one relationship
    @JoinColumn(name = "composition_id")
    @JsonBackReference
    private Composition composition;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "quantity")
    private Integer quantity;

    public CompositionItems() {
    }

    public CompositionItems(Composition composition, Item item, Integer quantity) {
        this.composition = composition;
        this.item = item;
        this.quantity = quantity;
        this.compositionItemsId = new CompositionItemsId();
        this.compositionItemsId.compositionId = composition.getId();
        this.compositionItemsId.itemId = item.getId();
    }

    public Composition getComposition() {
        return this.composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}

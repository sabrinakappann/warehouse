package com.storage.warehouse.compositionItemQuantity;

import com.storage.warehouse.composition.Composition;
import com.storage.warehouse.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "composition_item_quantity")
@IdClass(CompositionItemQuantityId.class)
public class CompositionItemQuantity {

    /*
    *  validar valores de qtds    *
    * */

    @Id
    @ManyToOne
    @JoinColumn(name = "composition_id", referencedColumnName = "id")
    private Composition composition;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;
    @Column(name = "quantity")
    private Integer quantity;

    public CompositionItemQuantity() {
    }

    public CompositionItemQuantity(Composition composition, Item item, Integer quantity) {
        this.composition = composition;
        this.item = item;
        this.quantity = quantity;
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



}

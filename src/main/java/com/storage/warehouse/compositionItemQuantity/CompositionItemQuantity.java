package com.storage.warehouse.compositionItemQuantity;

import com.storage.warehouse.composition.Composition;
import com.storage.warehouse.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "composition_item_quantity")
@IdClass(CompositionItemQuantityId.class)
public class CompositionItemQuantity {
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

}

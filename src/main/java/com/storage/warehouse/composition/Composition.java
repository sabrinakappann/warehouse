package com.storage.warehouse.composition;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.storage.warehouse.compositionItemsQuantities.CompositionItems;
import com.storage.warehouse.item.Item;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("COMPOSITION")
@Table(name = "compositions")
public class Composition extends Item {


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "composition")
    @JsonManagedReference
    private Set<CompositionItems> itemsOnCompositions;

    public Composition() {
        super();
        this.setItemType("COMPOSITION");
    }

    public Set<CompositionItems> getItemsOnCompositions() {
        return this.itemsOnCompositions;
    }

    public void setItemsOnCompositions(Set<CompositionItems> itemsOnCompositions) {
        this.itemsOnCompositions = itemsOnCompositions;
    }

}

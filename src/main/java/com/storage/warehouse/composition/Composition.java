package com.storage.warehouse.composition;

import com.storage.warehouse.compositionItemsQuantities.CompositionItems;
import com.storage.warehouse.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("COMPOSITION")
@Table(name = "compositions")
public class Composition extends Item {

    @OneToMany(mappedBy = "composition")
    private final Set<CompositionItems> compositionItemQuantities = new HashSet<>();

    public Composition() {
        super();
        this.setItemType("COMPOSITION");
    }

}

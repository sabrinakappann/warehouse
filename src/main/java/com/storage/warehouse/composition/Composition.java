package com.storage.warehouse.composition;

import com.storage.warehouse.compositionItemQuantity.CompositionItemQuantity;
import com.storage.warehouse.item.Item;
import com.storage.warehouse.item.ItemDTO;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("COMPOSITION")
@Table(name = "compositions")
public class Composition extends Item {

    @OneToMany(mappedBy = "composition")
    private Set<CompositionItemQuantity> compositionItemQuantities;

    public Composition() {
        super();
        this.setItemType("COMPOSITION");
        this.compositionItemQuantities = new HashSet<>();
    }

}

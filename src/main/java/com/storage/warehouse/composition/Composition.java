package com.storage.warehouse.composition;

import com.storage.warehouse.compositionItemQuantity.CompositionItemQuantity;
import com.storage.warehouse.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@DiscriminatorValue("COMPOSITION")
@Table(name = "compositions")
public class Composition extends Item {

    @OneToMany(mappedBy = "composition")
    private List<CompositionItemQuantity> compositionItemQuantities;

    public Composition() {
        super();
        this.setItemType("COMPOSITION");
    }

    // creates without items defined
    public Composition(String name, String description){
        super(name, description);
    }


}

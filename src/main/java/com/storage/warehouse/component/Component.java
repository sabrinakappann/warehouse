package com.storage.warehouse.component;

import com.storage.warehouse.composition.Composition;
import com.storage.warehouse.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@DiscriminatorValue("COMPONENT")
@Table(name = "COMPONENT")
public class Component extends Item {

    @ManyToMany
    private Set<Composition> compositions;

    // new register -> without qtd or price
    public Component(String name, String description){
        super(name, description);
    }

    public Component() {
        super();
    }

    public Set<Composition> getCompositions() {
        return this.compositions;
    }

    public void setCompositions(Set<Composition> compositions) {
        this.compositions = compositions;
    }
}

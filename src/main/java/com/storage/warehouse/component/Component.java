package com.storage.warehouse.component;

import com.storage.warehouse.composition.Composition;
import com.storage.warehouse.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@DiscriminatorValue("COMPONENT")
@Table(name = "COMPONENT")
public class Component extends Item {

    @ManyToMany
    private Set<Composition> compositions;

    // without define quantity
    public Component(BigDecimal unitPrice, Integer code, String name, String description) {
        super(unitPrice, code, name, description);
    }

    // with quantity
    public Component(BigDecimal unitPrice, Integer code, String name, String description, Integer quantity) {
        super(unitPrice, code, name, description, quantity);
    }

    public Set<Composition> getCompositions() {
        return this.compositions;
    }

    public void setCompositions(Set<Composition> compositions) {
        this.compositions = compositions;
    }
}

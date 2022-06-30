package com.storage.warehouse.component;

import com.storage.warehouse.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("COMPONENT")
@Table(name = "components")
public class Component extends Item {

    // new register -> without qtd or price
    public Component(String name, String description){
        super(name, description);
    }

    public Component() {
        super();
        this.setItemType("COMPONENT");
    }

}

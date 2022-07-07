package com.storage.warehouse.component;

import com.storage.warehouse.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("COMPONENT")
@Table(name = "components")
public class Component extends Item {

    public Component() {
        super();
        this.setItemType("COMPONENT");
    }

}

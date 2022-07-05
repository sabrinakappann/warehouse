package com.storage.warehouse.component.entity;

import com.storage.warehouse.item.entity.Item;

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

package com.storage.warehouse.item;

import com.storage.warehouse.compositionItemsQuantities.CompositionItems;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@DiscriminatorColumn(name = "ITEM_TYPE")
@Table(name = "items")
public abstract class Item implements Serializable {

    @SequenceGenerator(
            name = "item_sequence",
            allocationSize = 1,
            sequenceName = "item_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    @Id
    private Long id;
    private static final Long serialVersionUID = 1L;
    @Column(name="unit_price", columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal unitPrice;
    @Column(name="sell_price", columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal sellPrice;
    private String name;
    private String description;
    @Column(name = "ITEM_TYPE", insertable = false, updatable = false) // readonly property
    private String itemType;
    @OneToMany(mappedBy = "item")
    private Set<CompositionItems> compositionItemQuantities = new HashSet<>();

    public Item(String name, String description) {
        // Register an item without quantity or price
        this.setUnitPrice(BigDecimal.ZERO);
        this.setSellPrice(BigDecimal.ZERO);
        this.setName(name);
        this.setDescription(description);
    }

    public Item() {
        this.setUnitPrice(BigDecimal.ZERO);
        this.setSellPrice(BigDecimal.ZERO);
        this.setName("");
        this.setDescription("");
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType){
        this.itemType = itemType;
    }

    public Long getId() {
        return id;
    }


    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }


    public String getDescription() {
        return this.description;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Set<CompositionItems> getCompositionItemQuantities() {
        return compositionItemQuantities;
    }


    // 01-08 Classe Category => ver sobre equals e hashcode e add

    public boolean equals(Item item1, Item item2){
        return (item1.getName() == item2.getName() && item1.getDescription() == item2.getDescription());
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + " descr: " + this.getDescription();
    }
}
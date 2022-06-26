package com.storage.warehouse.item;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@DiscriminatorColumn(name = "ITEM_TYPE")
@Table(name = "ITEM")
public abstract class Item {

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
    private BigDecimal meanUnitPrice;
    private String name;
    private String description;
    private Integer quantity;
    private final BigDecimal initialPrice = BigDecimal.valueOf(0.0);
    private final Integer default_quantity = 0;


    public Item(String name, String description) {
        // Register an item without quantity or price
        this.setMeanUnitPrice(this.initialPrice);
        this.setName(name);
        this.setDescription(description);
        this.quantity = default_quantity;
    }

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public Integer getDefault_quantity() {
        return default_quantity;
    }



    public void setMeanUnitPrice(BigDecimal meanUnitPrice) {
        this.meanUnitPrice = meanUnitPrice;
    }

    public BigDecimal getMeanUnitPrice() {
        return this.meanUnitPrice;
    }

    public BigDecimal getTotalItemPrice() {
        return this.getMeanUnitPrice().multiply(BigDecimal.valueOf(this.getQuantity()));
    }

    public Integer getQuantity() {
        return this.quantity;
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

    public void setQuantity(Integer quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean equals(Item item1, Item item2){
        return (item1.getName() == item2.getName() && item1.getDescription() == item2.getDescription());
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + " descr: " + this.getDescription() + " (" + this.getQuantity() + ")";

    }
}
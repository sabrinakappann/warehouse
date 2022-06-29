package com.storage.warehouse.item;
import com.storage.warehouse.compositionItemQuantity.CompositionItemQuantity;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
    private BigDecimal unitPrice;
    private BigDecimal sellPrice;
    private String name;
    private String description;
    private final BigDecimal initialPrice = BigDecimal.valueOf(0.0);

    @OneToMany(mappedBy = "item")
    private List<CompositionItemQuantity> compositionItemQuantities;

    public Item(String name, String description) {
        // Register an item without quantity or price
        this.setUnitPrice(this.initialPrice);
        this.setName(name);
        this.setDescription(description);
    }

    public Item() {
        this.setUnitPrice(this.initialPrice);
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


    public boolean equals(Item item1, Item item2){
        return (item1.getName() == item2.getName() && item1.getDescription() == item2.getDescription());
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + " descr: " + this.getDescription();
    }
}
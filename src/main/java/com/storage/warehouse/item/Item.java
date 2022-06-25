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
    private BigDecimal unitPrice;
    private String name;
    private String description;
    private Integer quantity;
    BigDecimal TotalItemPrice;
    private final BigDecimal initialPrice = BigDecimal.valueOf(0.0);
    private final Integer default_quantity = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalItemPrice(BigDecimal totalItemPrice) {
        TotalItemPrice = totalItemPrice;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public Integer getDefault_quantity() {
        return default_quantity;
    }

    public Item(BigDecimal unitPrice, Integer code, String name, String description, Integer quantity) {
        // Creates an Item with unit price and quantity setted

        this.unitPrice = unitPrice;
        this.name = name;
        this.description = description;
        this.setQuantity(quantity);
    }

    public Item(BigDecimal unitPrice, Integer code, String name, String description){
        // Creates a single Item (quantity=1) with unit price

        this.setUnitPrice(unitPrice);
        this.setName(name);
        this.setDescription(description);
        this.quantity = default_quantity;
    }

    public Item(Integer code, String name, String description){
        // Creates a single Item (quantity=1) with unit price=0
        this.setUnitPrice(this.initialPrice);
        this.setName(name);
        this.setDescription(description);
        this.quantity = default_quantity;
    }

    public void setUnitPrice(BigDecimal unitPrice){
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public BigDecimal getTotalItemPrice(){
        return this.getUnitPrice().multiply(BigDecimal.valueOf(this.getQuantity()));
    }

    public Integer getQuantity() {
        return this.quantity;
    }



    public void setName(String name){
        this.name = name;
    }


    public void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return this.name;
    }


    public String getDescription(){
        return this.description;
    }

    public void setQuantity(Integer quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.getQuantity() + " unidade(s) de " + getName();
    }
}
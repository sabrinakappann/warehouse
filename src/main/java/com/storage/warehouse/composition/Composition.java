package com.storage.warehouse.composition;

import com.storage.warehouse.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.*;

@Entity
@DiscriminatorValue("COMPOSITION")
@Table(name = "COMPOSITION")
public class Composition extends Item {

    @ManyToMany
    private Set<Item> items;
    private BigDecimal TotalItemPrice;

    // creates without items defined
    public Composition(String name, String description){
        super(name, description);
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setAllItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public BigDecimal getCompositionUnitPrice(){
        BigDecimal total = BigDecimal.valueOf(0);
        this.items.forEach(item->total.add(item.getTotalItemPrice()));
        return total;
    }

    @Override
    public String toString() {
        String message = "";
        Iterator<Item> itemsIterator = items.iterator();
        while (itemsIterator.hasNext()) {
            message += itemsIterator.next().toString();
        }
        return message;
    }
}

package com.storage.warehouse.models;

import java.math.BigDecimal;
import java.util.*;

public class Composition extends Item {

    private List<Item> items;

    // creating with a single item
    public Composition(Integer code, String name, String description, Item item){
        super(code, name, description);
        this.items = new ArrayList<Item>();
        this.addItem(item);
    }

    // creating with list of items
    public Composition(Integer code, String name, String description, List<Item> items){
        super(code, name, description);
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
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

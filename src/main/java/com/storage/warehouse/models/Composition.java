package com.storage.warehouse.models;

import java.util.HashMap;
import java.util.Map;

public class Composition extends Component {

    private Map<Item, Integer> itemsQuantity;

    public Composition(Double price, Integer code, String name, String description) {
        super(price, code, name, description );
        this.itemsQuantity = new HashMap<Item,Integer>();
    }

    public Map<Item, Integer> getItemsQuantity() {
        return this.itemsQuantity;
    }

    public void addItem(Item item, Integer quantity){
        this.itemsQuantity.put(item, quantity);
    }

}

package com.storage.warehouse.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class Composition extends Component {

    private HashMap<Item, Integer> items_quantity;

    public Composition(BigDecimal price, Integer code, String name, String description) {
        super(price, code, name, description);
        this.items_quantity = new HashMap<Item, Integer>();
    }

    public HashMap<Item, Integer> getItems_quantity() {
        return this.items_quantity;
    }

    public void setItems_quantity(Item item, Integer quantity){
        if (items_quantity.containsKey(item)){
            Integer current_quantity = this.getItems_quantity().get(item);
            items_quantity.put(item, current_quantity+quantity);
        }else{
            items_quantity.put(item, quantity);
        }
    }
}

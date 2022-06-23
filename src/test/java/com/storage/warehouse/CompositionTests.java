package com.storage.warehouse;

import com.storage.warehouse.models.Composition;
import com.storage.warehouse.models.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class CompositionTests {

    @Test
    public void check_if_item_is_inserted_twice_with_quantities(){
        Composition composition1 = new Composition(new BigDecimal(20), 1, "c1", "d1");
        Composition composition2 = new Composition(new BigDecimal(20.33323), 2 , "c2", "d2");

        composition1.setItems_quantity(composition2, new Integer(5));
        HashMap<Item, Integer> items_quantity = composition1.getItems_quantity();

        assert items_quantity.containsKey(composition2);
        assert items_quantity.get(composition2) == 5;

    }

}

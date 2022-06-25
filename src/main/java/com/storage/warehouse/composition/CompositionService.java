package com.storage.warehouse.composition;

import com.storage.warehouse.component.Component;
import com.storage.warehouse.item.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompositionService {

    public Composition createTestCompositionFromListOfTestComponents() {
        // a hard coded test method. Works :)

        List<Item> components = new ArrayList<Item>();
        Item component1 = new Component(new BigDecimal(0.1), 1, "name1", "description1", 10);
        Item component2 = new Component(new BigDecimal(10), 2, "name2", "description2", 20);
        Item component3 = new Component(new BigDecimal(100), 3, "name3", "description3", 30);
        Item component4 = new Component(new BigDecimal(1000), 4, "name4", "description4", 40);

        components.add(component1);
        components.add(component2);
        components.add(component3);
        components.add(component4);
        return new Composition(123, "name composition", "description1 composition", components);
    }
}

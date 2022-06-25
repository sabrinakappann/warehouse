package com.storage.warehouse.component;

import com.storage.warehouse.composition.Composition;
import com.storage.warehouse.item.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Component extends Item {

    private List<Composition> compositionsWithThisComponent;

    // without define quantity
    public Component(BigDecimal unitPrice, Integer code, String name, String description) {
        super(unitPrice, code, name, description);
        this.compositionsWithThisComponent = new ArrayList<Composition>();
    }

    // with quantity
    public Component(BigDecimal unitPrice, Integer code, String name, String description, Integer quantity) {
        super(unitPrice, code, name, description, quantity);
        this.compositionsWithThisComponent = new ArrayList<Composition>();
    }

    public List<Composition> getCompositionsWithThisComponent(){
        return compositionsWithThisComponent;
    }

    public void addCompositionsItBelongs(Composition comp){
        compositionsWithThisComponent.add(comp);
    }

}

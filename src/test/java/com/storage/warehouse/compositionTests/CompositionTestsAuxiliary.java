package com.storage.warehouse.compositionTests;

import com.storage.warehouse.models.Component;
import com.storage.warehouse.models.Composition;
import com.storage.warehouse.models.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompositionTestsAuxiliary {
    // Auxiliary class to define named values to be used in CompositionTests, among with auxiliary methods
    // To create Compositions or Components in specific ways

    BigDecimal price1 = new BigDecimal(0.1);
    BigDecimal price2 = new BigDecimal(1.0);
    BigDecimal price3 = new BigDecimal(22.22);
    BigDecimal price4 = new BigDecimal(40.4040);

    Integer code1 = Integer.valueOf(1);
    Integer code2 = Integer.valueOf(2);
    Integer code3 = Integer.valueOf(3);
    Integer code4 = Integer.valueOf(4);

    String name1 = "name1";
    String name2 = "name1";
    String name3 = "name1";
    String name4 = "name1";

    String description1 = "description1";
    String description2 = "description2";
    String description3 = "description3";
    String description4 = "description4";

    Integer qtd1 = 10;
    Integer qtd2 = 100;
    Integer qtd3 = 1000;
    Integer qtd4 = 10000;

    Item component1 = new Component( price1,  code1,  name1,  description1,  qtd1);
    Item component2 = new Component( price2,  code2,  name2,  description2,  qtd2);
    Item component3 = new Component( price3,  code3,  name3,  description3,  qtd3);
    Item component4 = new Component( price4,  code4,  name4,  description4,  qtd4);

    public Composition composition1 = this.createTestCompositionFromListOfTestComponents();
    public Composition composition2= this.createTestCompositionFromListOfTestComponents();

    public CompositionTestsAuxiliary() {
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.code4 = code4;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.description1 = description1;
        this.description2 = description2;
        this.description3 = description3;
        this.description4 = description4;
        this.qtd1 = qtd1;
        this.qtd2 = qtd2;
        this.qtd3 = qtd3;
        this.qtd4 = qtd4;
        this.component1 = component1;
        this.component2 = component2;
        this.component3 = component3;
        this.component4 = component4;
    }

    public Composition createCompositionFromOneComponent(){
        return new Composition(code1, name1, description1, component1);
    }

    public Composition createTestCompositionFromListOfTestComponents(){
        List<Item> components = new ArrayList<Item>();
        components.add(component1);
        components.add(component2);
        components.add(component3);
        components.add(component4);
        return new Composition(code1, name1, description1, components);
    }

    public Composition createCompositionFromOneCompositionItem(){
        Composition composition1 = this.createTestCompositionFromListOfTestComponents();
        return new Composition(code1, name1, description1, composition1);
    }

    public Composition createCompositionFromListOfCompositionItem(){
        List<Item> compositions = new ArrayList<Item>();

        compositions.add(composition1);
        compositions.add(composition2);
        return new Composition(code1, name1, description1, compositions);
    }

}

package com.storage.warehouse.common.modelsCommon;

import com.storage.warehouse.models.Component;
import com.storage.warehouse.models.Composition;
import com.storage.warehouse.models.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompositionTestsAuxiliary {
    /* Auxiliary class to define named values to be used in CompositionTests, among with auxiliary methods to
        create Compositions or Components in specific ways. I know it is too hard coded and not intuitive to use,
        but it is usefull for now (junit better tests coming soon) */

    public BigDecimal price1;
    public BigDecimal price2;
    public BigDecimal price3;
    public BigDecimal price4;

    public Integer code1;
    public Integer code2;
    public Integer code3;
    public Integer code4;

    public String name1;
    public String name2;
    public String name3;
    public String name4;

    public String description1;
    public String description2;
    public String description3;
    public String description4;

    public Integer qtd1;
    public Integer qtd2;
    public Integer qtd3;
    public Integer qtd4;

    public Item component1;
    public Item component2;
    public Item component3;
    public Item component4;

    public Composition composition1;
    public Composition composition2;

    public CompositionTestsAuxiliary() {
        qtd1 = 10;
        qtd2 = 100;
        qtd3 = 1000;
        this.qtd4 = 10000;

        this.name1 = "name1";
        this.name2 = "name2";
        this.name3 = "name3";
        this.name4 = "name4";

        this.price1 = new BigDecimal("0.1");
        this.price2 = new BigDecimal("1.0");
        this.price3 = new BigDecimal("22.22");
        this.price4 = new BigDecimal("40.4040");

        code1 = 1;
        code2 = 2;
        code3 = 3;
        code4 = 4;

        description1 = "description1";
        description2 = "description2";
        description3 = "description3";
        description4 = "description4";

        component1 = new Component( price1,  code1,  name1,  description1,  qtd1);
        component2 = new Component( price2,  code2,  name2,  description2,  qtd2);
        component3 = new Component( price3,  code3,  name3,  description3,  qtd3);
        component4 = new Component( price4,  code4,  name4,  description4,  qtd4);

        composition1 = this.createTestCompositionFromListOfTestComponents();
        composition2= this.createTestCompositionFromListOfTestComponents();
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

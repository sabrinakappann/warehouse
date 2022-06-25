package com.storage.warehouse.itemTests;

import com.storage.warehouse.compositionTests.CompositionTestsAuxiliary;
import com.storage.warehouse.composition.Composition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemsControllersTest {

    @RequestMapping("/returnItemsAsJson")
    public String testReturnItemsAsJson(){
        CompositionTestsAuxiliary aux = new CompositionTestsAuxiliary();
        Composition composition2 = aux.composition2;
        return composition2.toString();
    }



}

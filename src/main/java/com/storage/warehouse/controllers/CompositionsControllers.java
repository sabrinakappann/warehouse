package com.storage.warehouse.controllers;
import com.storage.warehouse.models.Composition;
import com.storage.warehouse.models.services.CompositionServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class CompositionsControllers {

    CompositionServices composition_services = new CompositionServices();

    @RequestMapping("/getTestComposition")
    public List<Composition> getTestComposition() {
        // this mappes us to http://localhost:8080/
        Composition composition2 = composition_services.createTestCompositionFromListOfTestComponents();
        return List.of(composition2);
    }

}

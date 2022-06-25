package com.storage.warehouse.controllers;
import com.storage.warehouse.models.Composition;
import com.storage.warehouse.models.services.CompositionServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/composition")
public class CompositionsControllers {

    CompositionServices compositionServices = new CompositionServices();

    @GetMapping("/getTestComposition")
    public List<Composition> getTestComposition() {
        Composition composition2 = compositionServices.createTestCompositionFromListOfTestComponents();
        return List.of(composition2);
    }

}

package com.storage.warehouse.composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/composition")
public class CompositionsController {

    private final CompositionService compositionService;


    // compositionService injected into this constructor -> no need to be instanciated
    @Autowired
    public CompositionsController(CompositionService compositionService) {
        this.compositionService = compositionService;
    }


}

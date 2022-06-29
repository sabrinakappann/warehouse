package com.storage.warehouse.composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/compositions")
public class CompositionsController {
    // should only return DTO items

    private final CompositionService compositionService;

    // compositionService injected into this constructor -> no need to be instanciated
    @Autowired
    public CompositionsController(CompositionService compositionService) {
        this.compositionService = compositionService;
    }


}

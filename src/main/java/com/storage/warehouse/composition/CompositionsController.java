package com.storage.warehouse.composition;
import com.storage.warehouse.component.Component;
import com.storage.warehouse.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/composition")
public class CompositionsController {

    private final CompositionService compositionService;

    // compositionService injected into this constructor -> no need to be instanciated
    @Autowired
    public CompositionsController(CompositionService compositionService) {
        this.compositionService = compositionService;
    }

    @PostMapping(path = "new")
    public void createNewComposition(@RequestBody Map<Composition, Set<Item>> compositionAndItems) {
        compositionService.createNewComposition(compositionAndItems);
    }

}

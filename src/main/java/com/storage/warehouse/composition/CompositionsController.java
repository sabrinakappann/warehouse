package com.storage.warehouse.composition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/composition")
public class CompositionsController {

    CompositionService compositionService = new CompositionService();

    @GetMapping("/getTestComposition")
    public List<Composition> getTestComposition() {
        Composition composition2 = compositionService.createTestCompositionFromListOfTestComponents();
        return List.of(composition2);
    }

}

package com.storage.warehouse.component;

import com.storage.warehouse.composition.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/component")
public class ComponentController {

    private final ComponentService componentService;

    @Autowired // into this constructor -> no need to be instanciated
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @PostMapping(path = "newComponent")
    public void createNewComponent(@RequestBody Component component){
        componentService.createNewComponent(component);
    }
}

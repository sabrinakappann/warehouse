package com.storage.warehouse.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/components")
public class ComponentController {

    private final ComponentService componentService;

    @Autowired // into this constructor -> no need to be instanciated
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @PostMapping(path = "new")
    public void createNewComponent(@RequestBody Component component){
        componentService.createNewComponent(component);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Component>> findAlll(){
        // ResponseEntity.ok = builder for status code = 200
        return ResponseEntity.ok(componentService.getAllComponents());
    }


}


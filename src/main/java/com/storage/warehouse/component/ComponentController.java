package com.storage.warehouse.component;

import com.storage.warehouse.item.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/components")
public class ComponentController{
    // should only return DTO items

    private final ComponentService componentService;

    @Autowired // into this constructor -> no need to be instanciated
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @PostMapping()
    public ResponseEntity<ItemDTO> createNewComponent(@RequestBody ItemDTO componentDTO){
        ItemDTO newComponentDTO = this.componentService.createNewComponent(componentDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newComponentDTO.getId()).toUri(); // create new URI from request + the new generated id
        return  ResponseEntity.ok().body(newComponentDTO); // default 201 code when creating new resource + return id at header

    }

    @GetMapping(path = "allComponents")
    public ResponseEntity<List<ComponentDTO>> findAlllComponents(){
        // ResponseEntity.ok = builder for status code = 200
        return ResponseEntity.ok(this.componentService.findAllComponents());
    }


}


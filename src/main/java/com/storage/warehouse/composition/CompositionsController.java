package com.storage.warehouse.composition;

import com.storage.warehouse.compositionItemQuantity.CompositionItemQuantity;
import com.storage.warehouse.compositionItemQuantity.CompositionItemQuantityDTO;
import com.storage.warehouse.item.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping(path = "/new/empty")
    public ResponseEntity<ItemDTO> newEmptyComposition (@RequestBody ItemDTO compositionDTO){
        ItemDTO newCompositionDTO = this.compositionService.createNewComposition(compositionDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCompositionDTO.getId()).toUri(); // create new URI from request + the new generated id
        return  ResponseEntity.ok().body(newCompositionDTO); // default 201 code when creating new resource + return id at header

    }


}

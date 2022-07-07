package com.storage.warehouse.composition;

import com.storage.warehouse.item.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @PostMapping
    public ResponseEntity<CompositionDTO> newComposition(@RequestBody ItemDTO compositionDTO){
        CompositionDTO newCompositionDTO = this.compositionService.newCompositionWithoutItems(compositionDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCompositionDTO.getId()).toUri(); // create new URI from request + the new generated id
        return  ResponseEntity.ok().body(newCompositionDTO); // default 201 code when creating new resource + return id at header
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<CompositionDTO>> findAll(){
        return ResponseEntity.ok().body(compositionService.findAllCompositions());
    }

}

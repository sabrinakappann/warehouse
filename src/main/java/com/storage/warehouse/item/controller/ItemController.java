package com.storage.warehouse.item.controller;
import com.storage.warehouse.item.service.ItemService;
import com.storage.warehouse.item.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/items")
public class ItemController {
    // should only return DTO items

    @Autowired
    protected ItemService itemService;

    @GetMapping(path = "all")
    public ResponseEntity<List<ItemDTO>> findAllItems(){
        return ResponseEntity.ok().body(itemService.findAll());
    }

    @PostMapping // no need to specify path
    public ResponseEntity<ItemDTO> createNewItem(@RequestBody ItemDTO itemDTO){
        itemDTO = itemService.createNew(itemDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(itemDTO.getId()).toUri(); // create new URI from request + the new generated id
        return  ResponseEntity.ok().body(itemDTO); // default 201 code when creating new resource + return id at header

    }

}

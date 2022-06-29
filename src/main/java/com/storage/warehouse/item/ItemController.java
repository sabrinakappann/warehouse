package com.storage.warehouse.item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/items")
public class ItemController {
    // should only return DTO items

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "all")
    public ResponseEntity<List<ItemDTO>> findAll(){
        return ResponseEntity.ok().body(itemService.findAll());
    }

}

package com.storage.warehouse.item;

import com.storage.warehouse.composition.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}

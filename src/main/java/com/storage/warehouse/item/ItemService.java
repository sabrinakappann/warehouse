package com.storage.warehouse.item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service // dependency injection (@Component = generic)
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional(readOnly = true)
    public List<ItemDTO> findAll(){
        List<Item> allItems = this.itemRepository.findAll(); // but do NOT return Item entity directly
        List<ItemDTO> allItemsDTO = new ArrayList<>();
        for(Item item : allItems){
            allItemsDTO.add(new ItemDTO(item));
        }
        return allItemsDTO;
    }

}

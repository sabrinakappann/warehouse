package com.storage.warehouse.item;
import com.storage.warehouse.component.Component;
import com.storage.warehouse.composition.Composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // dependency injection (@Component = generic)
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional(readOnly = true)
    public List<ItemDTO> findAll() {
        List<Item> listRepository = this.itemRepository.findAll(); // but do NOT return Item entity directly

        // allItems.stream() => Converts list to stream to be able to use map()
        // map -> apply function (after ->) to each object i
        // collect(Collectors.toList()) -> convers stream to List
        List<ItemDTO> listDTO = listRepository.stream().map(x -> new ItemDTO(x)).collect(Collectors.toList()); // transform list of Item to list of ItemDTO
        return listDTO;
    }

    ////////////////////////////// TRATAR: SE FOR REPOSICAO, MANDAR P CAMADA DA COMPOSIÇÃO/
    ////////// tratar se vier sem item type


    @Transactional
    public ItemDTO createNew(ItemDTO itemDTO) {
        Item itemEntity;
        if (itemDTO.itemAtributes.getItemType() == ItemTypes.COMPONENT) {
            itemEntity = new Component();
        } else {
            itemEntity = new Composition();
        }
        itemEntity.setName(itemDTO.itemAtributes.getName());
        itemEntity.setDescription(itemDTO.itemAtributes.getDescription());
        itemEntity.setUnitPrice(itemDTO.itemAtributes.getUnitPrice());
        itemEntity.setSellPrice(itemDTO.itemAtributes.getSellPrice());
        Item newItemEntity = itemRepository.save(itemEntity);
        return new ItemDTO(newItemEntity);

        }

}
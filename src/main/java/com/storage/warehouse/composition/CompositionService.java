package com.storage.warehouse.composition;
import com.storage.warehouse.compositionItemsQuantities.CompositionItems;
import com.storage.warehouse.compositionItemsQuantities.CompositionItemsDTO;
import com.storage.warehouse.item.Item;
import com.storage.warehouse.item.ItemDTO;
import com.storage.warehouse.item.ItemRepository;
import com.storage.warehouse.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service // Service it is a kind of Component that I think is to the autowire onto controller works
public class CompositionService extends ItemService {

    private final CompositionRepository compositionRepository;

    @Autowired
    public CompositionService(CompositionRepository compositionRepository, ItemRepository itemRepository) {
        super(itemRepository);
        this.compositionRepository = compositionRepository;
    }


    public ItemDTO createNewEmptyComposition(ItemDTO compositionDTO) {
        compositionDTO.setItemType("COMPOSITION");
        ItemDTO newCompositionDTO = this.createNew(compositionDTO);
        return newCompositionDTO;
    }

    public CompositionDTO createNewComposition(CompositionDTO compositionDTO) {
        Set<CompositionItemsDTO> itemQuantityDTOSet = compositionDTO.getItemQuantitiesDTO();
        compositionDTO.setItemType("COMPOSITION");
        Set<CompositionItems> itemsQuantityEntity = new HashSet<>(); // conversion DTO -> Entity
        itemQuantityDTOSet.forEach(x -> itemsQuantityEntity.add(new CompositionItems(x.getComposition(), x.getItem(), x.getQuantity())));

        Composition compositionEntity = new Composition();

        compositionEntity.setItemType(compositionDTO.getItemType());
        compositionEntity.setName(compositionDTO.getName());
        compositionEntity.setDescription(compositionDTO.getDescription());
        compositionEntity.setUnitPrice(compositionDTO.getUnitPrice());
        compositionEntity.setSellPrice(compositionDTO.getSellPrice());
        compositionEntity.setCompositionItemQuantities(itemsQuantityEntity);

        ItemDTO newCompositionDTO = this.createNew(compositionDTO);

        Composition newCompositionEntity = this.compositionRepository.save(compositionEntity);
        return new CompositionDTO(newCompositionEntity);

    }

}




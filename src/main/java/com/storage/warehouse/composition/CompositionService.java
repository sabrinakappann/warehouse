package com.storage.warehouse.composition;
import com.storage.warehouse.compositionItemsQuantities.CompositionItemsRepository;
import com.storage.warehouse.item.ItemDTO;
import com.storage.warehouse.item.ItemRepository;
import com.storage.warehouse.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Service it is a kind of Component that I think is to the autowire onto controller works
public class CompositionService extends ItemService {

    @Autowired
    private CompositionRepository compositionRepository;
    @Autowired
    private CompositionItemsRepository compositionItemsRepository;

    @Autowired
    public CompositionService(CompositionRepository compositionRepository, ItemRepository itemRepository, CompositionItemsRepository compositionItemsRepository) {
        super(itemRepository);
        this.compositionRepository = compositionRepository;
        this.compositionItemsRepository = compositionItemsRepository;
    }

    @Transactional()
    public ItemDTO newCompositionWithoutItems(ItemDTO compositionDTO) {
        compositionDTO.setItemType("COMPOSITION");
        ItemDTO newCompositionDTO = this.createNew(compositionDTO);
        return newCompositionDTO;
    }


    private void copyCompositionDtoParamsToEntity(CompositionDTO compositionDTO, Composition compositionEntity){
        compositionEntity.setDescription(compositionDTO.getDescription());
        compositionEntity.setItemType(compositionDTO.getItemType());
        compositionEntity.setName(compositionDTO.getName());
        compositionEntity.setSellPrice(compositionDTO.getSellPrice());
        compositionEntity.setUnitPrice(compositionDTO.getUnitPrice());

    }

}




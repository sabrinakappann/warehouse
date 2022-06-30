package com.storage.warehouse.composition;
import com.storage.warehouse.item.Item;
import com.storage.warehouse.item.ItemDTO;
import com.storage.warehouse.item.ItemRepository;
import com.storage.warehouse.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Service it is a kind of Component that I think is to the autowire onto controller works
public class CompositionService extends ItemService {

    private final CompositionRepository compositionRepository;

    @Autowired
    public CompositionService(CompositionRepository compositionRepository, ItemRepository itemRepository) {
        super(itemRepository);
        this.compositionRepository = compositionRepository;
    }


    public ItemDTO createNewComposition(ItemDTO compositionDTO) {
        compositionDTO.setItemType("COMPOSITION");
        ItemDTO newCompositionDTO = this.createNew(compositionDTO);
        return newCompositionDTO;
    }
}




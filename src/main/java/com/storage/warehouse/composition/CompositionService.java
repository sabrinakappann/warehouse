package com.storage.warehouse.composition;
import com.storage.warehouse.compositionItemsQuantities.CompositionItemsRepository;
import com.storage.warehouse.item.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service // Service it is a kind of Component that I think is to the autowire onto controller works
public class CompositionService{

    @Autowired
    private CompositionRepository compositionRepository;
    @Autowired
    private CompositionItemsRepository compositionItemsRepository;


    @Autowired
    public CompositionService(CompositionRepository compositionRepository,  CompositionItemsRepository compositionItemsRepository) {
        this.compositionRepository = compositionRepository;
        this.compositionItemsRepository = compositionItemsRepository;
    }

    @Transactional()
    public CompositionDTO newCompositionWithoutItems(ItemDTO compositionDTO) {
        compositionDTO.setItemType("COMPOSITION");
        Composition itemEntity = new Composition();
        itemEntity.setName(compositionDTO.getName());
        itemEntity.setDescription(compositionDTO.getDescription());
        itemEntity.setUnitPrice(compositionDTO.getUnitPrice());
        itemEntity.setSellPrice(compositionDTO.getSellPrice());
        Composition newItemEntity = compositionRepository.save(itemEntity);
        return new CompositionDTO(newItemEntity);
    }

    @Transactional(readOnly = true)
    public List<CompositionDTO> findAllCompositions() {
        List<Composition> listRepository = this.compositionRepository.findAll();
        List<CompositionDTO> listDTO = listRepository.stream().map(x -> new CompositionDTO(x, x.getCompositionCompositionItems())).collect(Collectors.toList());
        return listDTO;
    }

    private void copyCompositionDtoParamsToEntity(CompositionDTO compositionDTO, Composition compositionEntity){
        compositionEntity.setDescription(compositionDTO.getDescription());
        compositionEntity.setItemType(compositionDTO.getItemType());
        compositionEntity.setName(compositionDTO.getName());
        compositionEntity.setSellPrice(compositionDTO.getSellPrice());
        compositionEntity.setUnitPrice(compositionDTO.getUnitPrice());

    }

}




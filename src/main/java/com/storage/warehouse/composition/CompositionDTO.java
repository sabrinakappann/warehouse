package com.storage.warehouse.composition;
import com.storage.warehouse.compositionItemsQuantities.CompositionItems;
import com.storage.warehouse.compositionItemsQuantities.CompositionItemsDTO;
import com.storage.warehouse.item.ItemDTO;

import java.util.HashSet;
import java.util.Set;

public class CompositionDTO extends ItemDTO {

    private Set<CompositionItemsDTO> itemQuantitiesDTO = new HashSet<>();

    public CompositionDTO(Composition compositionEntity){
        super(compositionEntity);
        this.setItemType("COMPOSITION");
        Set<CompositionItems> itemQuantities = compositionEntity.getCompositionItemQuantities();
        itemQuantities.forEach(c -> this.itemQuantitiesDTO.add(new CompositionItemsDTO(c)));
    }

    public CompositionDTO(Composition compositionEntity, Set<CompositionItems> itemQuantities){
        this(compositionEntity);
        this.setItemType("COMPOSITION");
        // converts each Set Item into DTO and add to itemQuantitiesDTO
        itemQuantities.forEach(c -> this.itemQuantitiesDTO.add(new CompositionItemsDTO(c)));
    }

    public CompositionDTO() {
        super();
        this.setItemType("COMPOSITION");
    }

    public Set<CompositionItemsDTO> getItemQuantitiesDTO() {
        return this.itemQuantitiesDTO;
    }

    public void setItemQuantitiesDTO(Set<CompositionItemsDTO> itemQuantitiesDTO) {
        this.itemQuantitiesDTO = itemQuantitiesDTO;
    }
    
/*
    public void addItem(Item item, Integer quantity){
        // se item já estava na lista, sobrepoe a quantidade
        // talvez tenha q ter o transformador desses parametros na entity e dps no DTO

        this.itemQuantitiesDTO.add(new CompositionItemsDTO());
    }
*/


}

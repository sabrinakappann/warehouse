package com.storage.warehouse.composition;

import com.storage.warehouse.compositionItemsQuantities.CompositionItems;
import com.storage.warehouse.compositionItemsQuantities.CompositionItemsDTO;
import com.storage.warehouse.item.ItemDTO;

import java.util.HashSet;
import java.util.Set;

public class CompositionDTO extends ItemDTO {

    private Set<CompositionItemsDTO> itemsOnComposition = new HashSet<>();

    public CompositionDTO(Composition compositionEntity){
        super(compositionEntity);
        this.setItemType("COMPOSITION");

    }

    public CompositionDTO(Composition compositionEntity, Set<CompositionItems> itemQuantities){
        this(compositionEntity);
        this.setItemType("COMPOSITION");
        // converts each Set Item into DTO and add to itemQuantitiesDTO
        itemQuantities.forEach(c -> this.itemsOnComposition.add(new CompositionItemsDTO(c)));
    }

    public CompositionDTO() {
        super();
        this.setItemType("COMPOSITION");
    }

    public Set<CompositionItemsDTO> getItemsOnComposition() {
        return this.itemsOnComposition;
    }

    public void setItemsOnComposition(Set<CompositionItemsDTO> itemsOnComposition) {
        this.itemsOnComposition = itemsOnComposition;
    }



/*
    public void addItem(Item item, Integer quantity){
        // se item já estava na lista, sobrepoe a quantidade
        // talvez tenha q ter o transformador desses parametros na entity e dps no DTO

        this.itemQuantitiesDTO.add(new CompositionItemsDTO());
    }
*/


}

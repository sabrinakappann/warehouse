package com.storage.warehouse.composition;
import com.storage.warehouse.compositionItemQuantity.CompositionItemQuantity;
import com.storage.warehouse.compositionItemQuantity.CompositionItemQuantityDTO;
import com.storage.warehouse.item.Item;
import com.storage.warehouse.item.ItemDTO;

import java.util.HashSet;
import java.util.Set;

public class CompositionDTO extends ItemDTO {

    private Set<CompositionItemQuantityDTO> itemQuantitiesDTO;

    public CompositionDTO(Composition compositionEntity){
        super(compositionEntity);
        this.setItemType("COMPOSITION");
        this.itemQuantitiesDTO = new HashSet<>();
    }

    public CompositionDTO(Composition itemEntity, Set<CompositionItemQuantity> itemQuantities){
        this(itemEntity);
        itemQuantities.forEach(CompositionItemQuantityDTO::new);
    }

/*
    public void addItem(Item item, Integer quantity){
        // se item já estava na lista, sobrepoe a quantidade
        // talvez tenha q ter o transformador desses parametros na entity e dps no DTO

        this.itemQuantitiesDTO.add(new CompositionItemQuantityDTO());
    }
*/


}

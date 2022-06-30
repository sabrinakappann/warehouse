package com.storage.warehouse.component;

import com.storage.warehouse.item.Item;
import com.storage.warehouse.item.ItemDTO;
import com.storage.warehouse.item.ItemRepository;
import com.storage.warehouse.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponentService extends ItemService {

    private final ComponentRepository componentRepository;

    @Autowired // auto dependency injection
    public ComponentService(ComponentRepository componentRepository, ItemRepository itemRepository) {
        super(itemRepository);
        this.componentRepository = componentRepository;
    }

    public ItemDTO createNewComponent(ItemDTO componentDTO){
        componentDTO.setItemType("COMPONENT");
        System.out.println("ITEM_TYPE SETTED = " + componentDTO.getItemType());
        return this.createNew(componentDTO);
    }

    public List<ComponentDTO> findAllComponents() {
        List<Component> componentList = this.componentRepository.findAll();
        List<ComponentDTO> componentDTOList = componentList.stream().map(x -> new ComponentDTO(x)).collect(Collectors.toList());
        return componentDTOList;
    }


    /*
    @Transactional(readOnly = true)
    public List<ComponentDTO> findAll() {
        List<Component> listRepository = this.componentRepository.findAll();
        List<ComponentDTO> listDTO = listRepository.stream().map(x -> new ComponentDTO(x)).collect(Collectors.toList());
        return listDTO;

    }*/
}

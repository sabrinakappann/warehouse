package com.storage.warehouse.component.service;

import com.storage.warehouse.component.dto.ComponentDTO;
import com.storage.warehouse.component.entity.Component;
import com.storage.warehouse.component.repository.ComponentRepository;
import com.storage.warehouse.item.dto.ItemDTO;
import com.storage.warehouse.item.repository.ItemRepository;
import com.storage.warehouse.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ItemDTO createNewComponent(ItemDTO componentDTO){
        componentDTO.setItemType("COMPONENT"); // ver se dá pra tirar por estar na entity ja
        return this.createNew(componentDTO);
    }

    @Transactional(readOnly = true)
    public List<ComponentDTO> findAllComponents() {
        List<Component> componentList = this.componentRepository.findAll();
        List<ComponentDTO> componentDTOList = componentList.stream().map(x -> new ComponentDTO(x)).collect(Collectors.toList());
        return componentDTOList;
    }

}

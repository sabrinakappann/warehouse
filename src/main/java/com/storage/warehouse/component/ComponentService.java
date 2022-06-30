package com.storage.warehouse.component;

import com.storage.warehouse.item.Item;
import com.storage.warehouse.item.ItemDTO;
import com.storage.warehouse.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComponentService {

    private final ComponentRepository componentRepository;

    @Autowired // auto dependency injection
    public ComponentService(ComponentRepository componentRepository, ItemRepository itemRepository) {
        this.componentRepository = componentRepository;
    }
/*
    public void createNewComponent(Component component){

        List<Optional<Component>> componentsWithSameName = componentRepository.findComponentByName(component.getName());
        List<Optional<Component>> componentsWithSameDescription = componentRepository.findComponentByDescription(component.getDescription());

        if(componentsWithSameName.isEmpty() || componentsWithSameDescription.isEmpty()){
            componentRepository.save(component);
            System.out.println("New component created: " + component.getName() + " - " + component.getDescription());
        }else{
            System.out.println("Same name and description components found:");
            System.out.println(componentsWithSameName);
            throw new InvalidParameterException("error: component already exists");
        }


    }

    @Transactional(readOnly = true)
    public List<ComponentDTO> findAll() {
        List<Component> listRepository = this.componentRepository.findAll();
        List<ComponentDTO> listDTO = listRepository.stream().map(x -> new ComponentDTO(x)).collect(Collectors.toList());
        return listDTO;

    }*/
}

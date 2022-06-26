package com.storage.warehouse.component;

import com.storage.warehouse.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {

    private final ComponentRepository componentRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ComponentService(ComponentRepository componentRepository, ItemRepository itemRepository) {
        this.componentRepository = componentRepository;
        this.itemRepository = itemRepository;
    }

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

}

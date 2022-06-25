package com.storage.warehouse.component;

import org.springframework.beans.factory.annotation.Autowired;

public class ComponentService {

    private final ComponentRepository componentRepository;

    @Autowired
    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }
}

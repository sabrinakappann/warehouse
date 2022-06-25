package com.storage.warehouse.composition;

import com.storage.warehouse.component.Component;
import com.storage.warehouse.component.ComponentRepository;
import com.storage.warehouse.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service // Service it is a kind of Component that I think is to the autowire onto controller works
public class CompositionService {

    private final CompositionRepository compositionRepository;

    @Autowired
    public CompositionService(CompositionRepository compositionRepository) {
        this.compositionRepository = compositionRepository;
    }


}

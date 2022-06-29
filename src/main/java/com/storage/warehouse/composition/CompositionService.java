package com.storage.warehouse.composition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Service it is a kind of Component that I think is to the autowire onto controller works
public class CompositionService {

    private final CompositionRepository compositionRepository;

    @Autowired
    public CompositionService(CompositionRepository compositionRepository) {
        this.compositionRepository = compositionRepository;
    }


}




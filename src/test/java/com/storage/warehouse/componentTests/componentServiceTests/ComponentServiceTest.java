package com.storage.warehouse.componentTests.componentServiceTests;

import com.storage.warehouse.component.service.ComponentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ComponentServiceTest {

    private final ComponentService componentService;

    @Autowired
    public ComponentServiceTest(ComponentService componentService) {
        this.componentService = componentService;
    }

    @Test
    public void testIfComponentWasCreated(){

    }
}

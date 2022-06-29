package com.storage.warehouse.home;

import com.storage.warehouse.component.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String showHelloWorldMessage(){
        return "Hello World!";
    }

}

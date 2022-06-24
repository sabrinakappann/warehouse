package com.storage.warehouse;

import com.storage.warehouse.models.Component;
import com.storage.warehouse.models.Composition;
import com.storage.warehouse.models.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class WarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class, args);
    }

    @GetMapping
    public String home() {
        // this mappes us to http://localhost:8080/
        return "Hello World!";
    }

}


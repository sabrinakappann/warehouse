package com.storage.warehouse.security.serverSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean // Spring component, just like services, entities etc but for method
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // can be autowired because of @Bean
    }

}

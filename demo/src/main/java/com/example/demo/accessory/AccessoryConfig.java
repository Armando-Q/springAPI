package com.example.demo.accessory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AccessoryConfig {

    @Bean
     CommandLineRunner accessorycommandLineRunner(
            AccessoryRepository repository){
        return args -> {
            Accessory helmet = new Accessory(
                    "helmet",
                    235.65

            );

            Accessory gloves = new Accessory(
                    "gloves",
                    54.34
            );

            repository.saveAll(
                    Arrays.asList(helmet,gloves));
        };
    }

}

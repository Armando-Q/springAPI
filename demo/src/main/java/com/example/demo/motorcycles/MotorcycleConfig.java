package com.example.demo.motorcycles;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;



@Configuration
public class MotorcycleConfig {


    @Bean
    CommandLineRunner motorcyclecommandLineRunner(
            MotorcycleRepository repository){
        return args -> {
            Motorcycle vulcan = new  Motorcycle(
                    "Kawasaki",
                    "Vulcan",
                    2009,
                    9743.23
            );
            Motorcycle rebel = new  Motorcycle(
                    "Honda",
                    "Rebel",
                    1997,
                    3458.12
            );


            repository.saveAll(
                    Arrays.asList(vulcan, rebel)
            );


        };
    }
}

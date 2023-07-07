package com.example.demo.rider;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;




@Configuration
public class RiderConfig {


    @Bean
    CommandLineRunner ridercommandLineRunner(
            RiderRepository repository){
        return args -> {
            Rider Armando = new Rider(
                    "Armando",
                    "Quinonez",
                    "Intermediate",
                    25
            );
            Rider Hunter = new  Rider(
                    "Hunter",
                    "Wright",
                    "Intermediate",
                    23
            );


            repository.saveAll(
                    Arrays.asList(Armando, Hunter)
            );


        };
    }
}

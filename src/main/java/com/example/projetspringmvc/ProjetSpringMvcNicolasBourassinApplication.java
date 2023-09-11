package com.example.projetspringmvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ProjetSpringMvcNicolasBourassinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringMvcNicolasBourassinApplication.class, args);
    }

    @Bean
    @Profile("!test")
    CommandLineRunner commandLineRunner() {
        return args -> {
            //tests ici :

        };
    }


    }

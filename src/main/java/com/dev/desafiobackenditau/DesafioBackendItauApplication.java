package com.dev.desafiobackenditau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DesafioBackendItauApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioBackendItauApplication.class, args);
    }

}

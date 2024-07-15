package com.smarthint.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class SmarthintBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmarthintBackendApplication.class, args);
    }

}

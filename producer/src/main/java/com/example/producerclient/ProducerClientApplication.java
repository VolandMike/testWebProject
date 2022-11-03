package com.example.producerclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProducerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerClientApplication.class, args);
    }

}

package com.alphasmart.alphaspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AlphaspringApplication {
    private static final Logger log = LoggerFactory.getLogger(AlphaspringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AlphaspringApplication.class, args);
    }


}

package com.alphasmart.alphaspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AlphaspringApplication {
    private static final Logger log = LoggerFactory.getLogger(AlphaspringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AlphaspringApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://www.quandl.com/api/v3/datasets/EURONEXT/ADYEN.json?api_key=f_tQibQDxz8s2CABjKZU", Quote.class);
            log.info(quote.toString());
            System.out.println(quote.toString());
        };
    }

}

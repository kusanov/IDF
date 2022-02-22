package com.idfin.kusanov.cryptocurrency;

import com.idfin.kusanov.cryptocurrency.entity.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableScheduling
public class CryptocurrencyApplication {

    private static final Logger log = LoggerFactory.getLogger(CryptocurrencyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CryptocurrencyApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

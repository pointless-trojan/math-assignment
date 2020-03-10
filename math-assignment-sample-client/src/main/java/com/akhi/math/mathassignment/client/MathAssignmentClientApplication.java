package com.akhi.math.mathassignment.client;

import com.akhi.math.mathassignment.model.DataSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MathAssignmentClientApplication {
    private static final Logger logger = LoggerFactory.getLogger(MathAssignmentClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MathAssignmentClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return arg -> {
            DataSeries ds = restTemplate.getForObject(
                    "http://localhost:8080/v1.0/1/5", DataSeries.class);
            logger.info("Result with version 1 and range of 1 & 5 - " + ds.getSeries().toString());

            ds = restTemplate.getForObject(
                    "http://localhost:8080/v2.0/47/57", DataSeries.class);

            logger.info("Result with version 2 and range of 1 & 5 - " + ds.getSeries().toString());
        };

    }

}

package com.example.customerconsolidinfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients("com.example.customerconsolidinfo.feignclients")
public class CustomerConsolidInfoApplication {
    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public WebClient webClient(){
        WebClient webClient=WebClient.builder()
                .baseUrl(customerServiceUrl).build();
        return webClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerConsolidInfoApplication.class, args);
    }

}

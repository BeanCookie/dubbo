package com.zeaho.ms.dubbo.consumer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author lzzz
 */
@Configuration
public class DubboConfig {
    @Bean
    public RestTemplate providerRestTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.of(3, ChronoUnit.SECONDS))
            .setReadTimeout(Duration.of(5, ChronoUnit.SECONDS))
            .rootUri("http://localhost:8899/")
            .build();}
}

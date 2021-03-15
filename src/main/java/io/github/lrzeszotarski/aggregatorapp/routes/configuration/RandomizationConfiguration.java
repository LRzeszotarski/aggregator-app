package io.github.lrzeszotarski.aggregatorapp.routes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomizationConfiguration {

    @Bean
    public Random random() {
        return new Random();
    }
}

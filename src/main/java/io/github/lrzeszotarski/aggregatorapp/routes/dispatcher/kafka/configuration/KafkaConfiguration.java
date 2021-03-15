package io.github.lrzeszotarski.aggregatorapp.routes.dispatcher.kafka.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.test.EmbeddedKafkaBroker;

@Configuration
public class KafkaConfiguration {
    @Bean
    EmbeddedKafkaBroker broker() {
        return new EmbeddedKafkaBroker(1)
                .kafkaPorts(9092)
                .brokerProperty("listeners", "PLAINTEXT://localhost:9092")
                .brokerProperty("advertised.listeners", "PLAINTEXT://localhost:9092")
                .brokerProperty("listener.security.protocol.map", "PLAINTEXT:PLAINTEXT,REMOTE:PLAINTEXT")
                .brokerListProperty("spring.kafka.bootstrap-servers");
    }
}

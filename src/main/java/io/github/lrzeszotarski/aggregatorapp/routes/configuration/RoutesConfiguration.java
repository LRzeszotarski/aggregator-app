package io.github.lrzeszotarski.aggregatorapp.routes.configuration;

import io.github.lrzeszotarski.aggregatorapp.routes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoutesConfiguration {

    private final List<Connector> connectors;

    private final List<Dispatcher> dispatchers;

    private final Aggregator aggregator;

    public RoutesConfiguration(List<Connector> connectors, List<Dispatcher> dispatchers, Aggregator aggregator) {
        this.connectors = connectors;
        this.dispatchers = dispatchers;
        this.aggregator = aggregator;
    }

    @Bean
    public Route route() {
        return new RouteBuilder()
                .from(connectors)
                .aggregate(aggregator)
                .to(dispatchers)
                .build();
    }
}

package io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa;

import io.github.lrzeszotarski.aggregatorapp.routes.Connector;
import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.ConnectorInputService;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class JpaConnector implements Connector<Integer> {

    private final ConnectorInputService connectorInputService;

    public JpaConnector(ConnectorInputService connectorInputService) {
        this.connectorInputService = connectorInputService;
    }

    @Override
    public Stream<Integer> fetch() {
        return connectorInputService.fetchInput();
    }
}

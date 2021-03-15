package io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain;

import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.entity.ConnectorInput;
import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.repository.ConnectorInputRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class ConnectorInputService {

    private final ConnectorInputRepository connectorInputRepository;

    public ConnectorInputService(ConnectorInputRepository connectorInputRepository) {
        this.connectorInputRepository = connectorInputRepository;
    }

    public Stream<Integer> fetchInput() {
        final List<ConnectorInput> allToImport = connectorInputRepository.findAllByImported(false);
        allToImport.forEach(input -> input.setImported(true));
        return allToImport.stream().map(ConnectorInput::getValue);
    }
}

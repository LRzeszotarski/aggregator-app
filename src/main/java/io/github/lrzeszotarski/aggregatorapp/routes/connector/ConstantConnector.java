package io.github.lrzeszotarski.aggregatorapp.routes.connector;

import io.github.lrzeszotarski.aggregatorapp.routes.Connector;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ConstantConnector implements Connector<Integer> {

    @Override
    public Stream<Integer> fetch() {
        return Stream.generate(() -> 1).limit(1000);
    }
}

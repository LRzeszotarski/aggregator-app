package io.github.lrzeszotarski.aggregatorapp.routes.connector;

import io.github.lrzeszotarski.aggregatorapp.routes.Connector;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Stream;

@Component
public class SimpleRandomConnector implements Connector<Integer> {

    private final Random random;

    public SimpleRandomConnector(Random random) {
        this.random = random;
    }

    @Override
    public Stream<Integer> fetch() {
        return Stream.generate(() -> random.nextInt(100)).limit(1000);
    }

}

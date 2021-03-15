package io.github.lrzeszotarski.aggregatorapp.routes.connector;

import io.github.lrzeszotarski.aggregatorapp.routes.Connector;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.stream.Stream;

@Component
public class BigIntegerConnector implements Connector<BigInteger> {
    @Override
    public Stream<BigInteger> fetch() {
        return Stream.generate(() -> BigInteger.ONE).limit(1000);
    }
}

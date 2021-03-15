package io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method;

import io.github.lrzeszotarski.aggregatorapp.routes.Aggregator;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class BigIntegerAndIntegerMethod implements Aggregator.Method<BigInteger, Integer, Integer> {

    @Override
    public Integer execute(BigInteger bigInteger, Integer integer) {
        return bigInteger.intValue() + integer;
    }
}

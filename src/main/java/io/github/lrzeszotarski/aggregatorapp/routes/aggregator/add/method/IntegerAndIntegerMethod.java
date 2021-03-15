package io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method;

import io.github.lrzeszotarski.aggregatorapp.routes.Aggregator;
import org.springframework.stereotype.Component;

@Component
public class IntegerAndIntegerMethod implements Aggregator.Method<Integer, Integer, Integer> {

    @Override
    public Integer execute(Integer integer1, Integer integer2) {
        return integer1 + integer2;
    }
}

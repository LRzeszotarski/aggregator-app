package io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add;

import io.github.lrzeszotarski.aggregatorapp.routes.Aggregator;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class AddAggregator implements Aggregator<Object> {

    private final MethodEvaluator methodEvaluator;

    public AddAggregator(MethodEvaluator methodEvaluator) {
        this.methodEvaluator = methodEvaluator;
    }

    @Override
    public Object aggreagate(Stream<Object> input) {
        return input.reduce(0, (l, r) -> methodEvaluator.evaluate(l, r));
    }
}

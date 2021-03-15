package io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add;

import io.github.lrzeszotarski.aggregatorapp.routes.aggregator.exception.NotHandledAggregationMethodException;
import io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method.BigIntegerAndIntegerMethod;
import io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method.IntegerAndIntegerMethod;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class MethodEvaluator {

    private final IntegerAndIntegerMethod integerAndIntegerMethod;

    private final BigIntegerAndIntegerMethod bigIntegerAndIntegerMethod;

    public MethodEvaluator(IntegerAndIntegerMethod integerAndIntegerMethod, BigIntegerAndIntegerMethod bigIntegerAndIntegerMethod) {
        this.integerAndIntegerMethod = integerAndIntegerMethod;
        this.bigIntegerAndIntegerMethod = bigIntegerAndIntegerMethod;
    }

    <T, U, V> V evaluate(T l, U r) {
        if (l instanceof Integer && r instanceof Integer) {
            return (V) integerAndIntegerMethod.execute((Integer) l, (Integer) r);
        }
        if (l instanceof BigInteger && r instanceof Integer) {
            return (V) bigIntegerAndIntegerMethod.execute((BigInteger) l, (Integer) r);
        }
        if (l instanceof Integer && r instanceof BigInteger) {
            return (V) bigIntegerAndIntegerMethod.execute((BigInteger) r, (Integer) l);
        }
        else {
            throw new NotHandledAggregationMethodException();
        }
    }
}

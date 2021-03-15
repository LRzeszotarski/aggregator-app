package io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add

import io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method.BigIntegerAndIntegerMethod
import io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method.IntegerAndIntegerMethod
import spock.lang.Specification

import java.util.stream.Stream

class AddAggregatorTest extends Specification {

    def integerAndIntegerMethod = Spy(IntegerAndIntegerMethod)

    def bigIntegerAndIntegerMethod = Spy(BigIntegerAndIntegerMethod)

    def methodEvaluator = new MethodEvaluator(integerAndIntegerMethod, bigIntegerAndIntegerMethod)

    def testedInstance = new AddAggregator(methodEvaluator)

    def "should sum integers to integer"() {
        given:

        when:
        def result = testedInstance.aggreagate(Stream.of(1, 1, 2, 3, 5, 8, 13, 21))

        then:
        result == 54
    }

    def "should sum bigintegers and integers to integer"() {
        given:

        when:
        def result = testedInstance.aggreagate(Stream.of(BigInteger.ONE, BigInteger.ONE, BigInteger.TWO, 3, 5, 8, 13, 21))

        then:
        result == 54
    }

    def "should sum bigintegers to integer"() {
        given:

        when:
        def result = testedInstance.aggreagate(Stream.of(BigInteger.ONE, BigInteger.ONE, BigInteger.TWO))

        then:
        result == 4
    }
}

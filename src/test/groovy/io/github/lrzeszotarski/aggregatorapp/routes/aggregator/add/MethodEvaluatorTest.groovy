package io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add

import io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method.BigIntegerAndIntegerMethod
import io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method.IntegerAndIntegerMethod
import io.github.lrzeszotarski.aggregatorapp.routes.aggregator.exception.NotHandledAggregationMethodException
import spock.lang.Specification

class MethodEvaluatorTest extends Specification {

    def integerAndIntegerMethod = Mock(IntegerAndIntegerMethod)

    def bigIntegerAndIntegerMethod = Mock(BigIntegerAndIntegerMethod)

    def testedInstance = new MethodEvaluator(integerAndIntegerMethod, bigIntegerAndIntegerMethod)

    def "should use IntegerAndIntegerMethod when both parameters are integers"() {
        given:

        when:
        testedInstance.evaluate(1, 1)

        then:
        1 * integerAndIntegerMethod.execute(1, 1)
    }

    def "should use BigIntegerAndIntegerMethod when parameters are integer and biginteger"() {
        given:

        when:
        testedInstance.evaluate(1, BigInteger.ONE)

        then:
        1 * bigIntegerAndIntegerMethod.execute(1, BigInteger.ONE)
    }

    def "should use BigIntegerAndIntegerMethod when parameters are biginteger and integer"() {
        given:

        when:
        testedInstance.evaluate(BigInteger.ONE, 1)

        then:
        1 * bigIntegerAndIntegerMethod.execute(1, BigInteger.ONE)
    }

    def "should throw exception when parameter types are not handled"() {
        given:

        when:
        testedInstance.evaluate("1", 1)

        then:
        thrown(NotHandledAggregationMethodException)
    }
}

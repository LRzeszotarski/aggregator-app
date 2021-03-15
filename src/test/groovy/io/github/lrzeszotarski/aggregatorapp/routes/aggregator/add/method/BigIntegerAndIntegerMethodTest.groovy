package io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method

import spock.lang.Specification

class BigIntegerAndIntegerMethodTest extends Specification {

    def testedInstance = new BigIntegerAndIntegerMethod()

    def "should add BigInteger to Integer"() {
        given:

        when:
        def result = testedInstance.execute(BigInteger.TWO, 1)

        then:
        result == 3
    }
}

package io.github.lrzeszotarski.aggregatorapp.routes.aggregator.add.method

import spock.lang.Specification

class IntegerAndIntegerMethodTest extends Specification {

    def testedInstance = new IntegerAndIntegerMethod()

    def "should add integer and integer"() {
        given:

        when:
        def result = testedInstance.execute(2, 5)

        then:
        result == 7
    }
}

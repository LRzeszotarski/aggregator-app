package io.github.lrzeszotarski.aggregatorapp.routes.connector

import spock.lang.Specification

import java.util.stream.Collectors

class BigIntegerConnectorTest extends Specification {

    def testedInstance = new BigIntegerConnector()

    def "Fetch should generate 1000 big integers"() {
        given:

        when:
        def result = testedInstance.fetch()

        then:
        def collectedResult = result.collect(Collectors.toList())
        collectedResult.size() == 1000
    }
}

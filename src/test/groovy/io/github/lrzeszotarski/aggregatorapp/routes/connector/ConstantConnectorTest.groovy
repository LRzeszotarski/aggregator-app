package io.github.lrzeszotarski.aggregatorapp.routes.connector

import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.Stream

class ConstantConnectorTest extends Specification {

    def testedInstance = new ConstantConnector()

    def "Fetch should genereate 1000 integers and all equal 1"() {
        given:

        when:
        def result = testedInstance.fetch()

        then:
        def collectedResult = result.collect(Collectors.toList())
        collectedResult.size() == 1000
        collectedResult == Stream.generate(() -> 1).limit(1000).collect(Collectors.toList())
    }
}

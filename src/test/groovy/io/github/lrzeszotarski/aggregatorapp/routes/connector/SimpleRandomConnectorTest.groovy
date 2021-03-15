package io.github.lrzeszotarski.aggregatorapp.routes.connector

import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.Stream

class SimpleRandomConnectorTest extends Specification {

    def random = Mock(Random)

    def testedInstance = new SimpleRandomConnector(random)

    def "Fetch should generate 1000 random integers"() {
        given:
        random.nextInt(100) >> 1024

        when:
        def result = testedInstance.fetch()

        then:
        def collectedResult = result.collect(Collectors.toList())
        collectedResult.size() == 1000
        collectedResult == Stream.generate(() -> 1024).limit(1000).collect(Collectors.toList())
    }
}

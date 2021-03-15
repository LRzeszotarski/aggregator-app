package io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain

import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.entity.ConnectorInput
import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.repository.ConnectorInputRepository
import spock.lang.Specification

import java.util.stream.Collectors

class ConnectorInputServiceTest extends Specification {

    def connectorInputRepository = Mock(ConnectorInputRepository)

    def testedInstance = new ConnectorInputService(connectorInputRepository)

    def "FetchInput should mark input records as imported and map them to values"() {
        given:
        def _1stInput = new ConnectorInput(1, 1, false)
        def _2ndInput = new ConnectorInput(2, 3, false)

        and:
        1 * connectorInputRepository.findAllByImported(false) >> [_1stInput, _2ndInput]

        when:
        def result = testedInstance.fetchInput()

        then:
        _1stInput.getImported()
        _2ndInput.getImported()
        def collectedResult = result.collect(Collectors.toList())
        collectedResult.size() == 2
        collectedResult.containsAll([1, 3])
    }
}

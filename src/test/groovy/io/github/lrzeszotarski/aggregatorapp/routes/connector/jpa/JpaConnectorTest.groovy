package io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa

import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.ConnectorInputService
import spock.lang.Specification

class JpaConnectorTest extends Specification {

    def connectorInputService = Mock(ConnectorInputService)

    def testedInstance = new JpaConnector(connectorInputService)

    def "Fetch should call ConnectorInputService"() {
        given:

        when:
        testedInstance.fetch()

        then:
        1 * connectorInputService.fetchInput()
    }
}

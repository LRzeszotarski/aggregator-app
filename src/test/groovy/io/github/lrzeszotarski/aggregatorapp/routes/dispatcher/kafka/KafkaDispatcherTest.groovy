package io.github.lrzeszotarski.aggregatorapp.routes.dispatcher.kafka

import spock.lang.Specification

class KafkaDispatcherTest extends Specification {

    def dispatcherOutputService = Mock(DispatcherOutputService)

    def testedInstance = new KafkaDispatcher(dispatcherOutputService)

    def "should Dispatch to DispatcherOutputService"() {
        given:

        when:
        testedInstance.dispatch(100)

        then:
        1 * dispatcherOutputService.sendDispatcherOutput(100.toString())
    }
}

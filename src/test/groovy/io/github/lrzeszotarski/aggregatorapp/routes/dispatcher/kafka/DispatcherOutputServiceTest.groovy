package io.github.lrzeszotarski.aggregatorapp.routes.dispatcher.kafka

import org.springframework.kafka.core.KafkaTemplate
import spock.lang.Specification

class DispatcherOutputServiceTest extends Specification {

    def kafkaTemplate = Mock(KafkaTemplate)

    def testedInstance = new DispatcherOutputService(kafkaTemplate)

    def "SendDispatcherOutput should send message"() {
        given:
        def message = "message"

        when:
        testedInstance.sendDispatcherOutput(message)

        then:
        1 * kafkaTemplate.send(DispatcherOutputService.TOPIC, message)
    }
}

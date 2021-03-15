package io.github.lrzeszotarski.aggregatorapp.routes.dispatcher.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DispatcherOutputService {

    protected static final String TOPIC = "dispatcher_output";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public DispatcherOutputService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendDispatcherOutput(String dispatcherOutput) {
        kafkaTemplate.send(TOPIC, dispatcherOutput);
    }
}

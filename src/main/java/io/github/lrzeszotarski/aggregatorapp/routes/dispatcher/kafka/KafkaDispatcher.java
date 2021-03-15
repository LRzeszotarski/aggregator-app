package io.github.lrzeszotarski.aggregatorapp.routes.dispatcher.kafka;

import io.github.lrzeszotarski.aggregatorapp.routes.Dispatcher;
import org.springframework.stereotype.Component;

@Component
public class KafkaDispatcher implements Dispatcher<Integer> {

    private final DispatcherOutputService dispatcherOutputService;

    public KafkaDispatcher(DispatcherOutputService dispatcherOutputService) {
        this.dispatcherOutputService = dispatcherOutputService;
    }

    @Override
    public void dispatch(Integer value) {
        dispatcherOutputService.sendDispatcherOutput(value.toString());
    }
}

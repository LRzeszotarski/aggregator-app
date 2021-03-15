package io.github.lrzeszotarski.aggregatorapp.routes.dispatcher;

import io.github.lrzeszotarski.aggregatorapp.routes.Dispatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogDispatcher implements Dispatcher<Integer> {
    @Override
    public void dispatch(Integer value) {
        log.info("Current value {}", value);
    }
}

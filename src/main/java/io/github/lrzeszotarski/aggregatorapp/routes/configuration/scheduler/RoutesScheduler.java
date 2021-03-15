package io.github.lrzeszotarski.aggregatorapp.routes.configuration.scheduler;

import io.github.lrzeszotarski.aggregatorapp.routes.Route;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RoutesScheduler {

    private final Route route;

    public RoutesScheduler(Route route) {
        this.route = route;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {
        route.start();
    }
}

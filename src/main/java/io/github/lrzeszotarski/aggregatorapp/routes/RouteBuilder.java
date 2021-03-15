package io.github.lrzeszotarski.aggregatorapp.routes;

import java.util.List;
import java.util.stream.Stream;

public class RouteBuilder<T> {

    private List<Connector> connectors;

    private List<Dispatcher> dispatchers;

    private Aggregator aggregator;

    public RouteBuilder from(List<Connector> connectors) {
        this.connectors = connectors;
        return this;
    }

    public RouteBuilder aggregate(Aggregator aggregator) {
        this.aggregator = aggregator;
        return this;
    }

    public RouteBuilder to(List<Dispatcher> dispatchers) {
        this.dispatchers = dispatchers;
        return this;
    }

    public Route build() {
        return () -> {
            final Object aggreagate = aggregator.aggreagate(connectors.stream().map(Connector::fetch)
                    .reduce(Stream.empty(), (left, right) ->
                            Stream.concat(left, right)));
            dispatchers.forEach(dispatcher -> dispatcher.dispatch(aggreagate));
        };
    }
}

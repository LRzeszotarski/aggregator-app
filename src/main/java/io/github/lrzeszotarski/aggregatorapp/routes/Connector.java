package io.github.lrzeszotarski.aggregatorapp.routes;

import java.util.stream.Stream;

public interface Connector<T> {
    Stream<T> fetch();
}

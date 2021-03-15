package io.github.lrzeszotarski.aggregatorapp.routes;

public interface Dispatcher<T> {
    void dispatch(T value);
}

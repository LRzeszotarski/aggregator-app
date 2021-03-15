package io.github.lrzeszotarski.aggregatorapp;

import io.github.lrzeszotarski.aggregatorapp.routes.Dispatcher;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestDispatcher implements Dispatcher<Integer> {

    private Integer value;

    @Override
    public void dispatch(Integer value) {
        this.value = value;
    }
}

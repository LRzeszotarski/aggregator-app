# aggregator-app
Spring Boot Aggregator microservice application that collects data from various data sources, aggregates and sends it to the various handlers.

Architecture based on three components:

- Connector

- Aggregator

- Dispatcher

To implement a new connector you should implement the Connector interface and annotate your component as a Spring Component
```
@Component
```

# Connector Example
```
@Component
public class SimpleRandomConnector implements Connector<Integer> {

    private final Random random;

    public SimpleRandomConnector(Random random) {
        this.random = random;
    }

    @Override
    public Stream<Integer> fetch() {
        return Stream.generate(() -> random.nextInt(100)).limit(1000);
    }

}
```

H2 Console
===========
http://localhost:8080/h2-console/


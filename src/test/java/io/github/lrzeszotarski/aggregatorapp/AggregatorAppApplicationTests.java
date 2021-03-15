package io.github.lrzeszotarski.aggregatorapp;

import io.github.lrzeszotarski.aggregatorapp.routes.Route;
import io.github.lrzeszotarski.aggregatorapp.routes.configuration.scheduler.RoutesScheduler;
import io.github.lrzeszotarski.aggregatorapp.routes.connector.SimpleRandomConnector;
import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.entity.ConnectorInput;
import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.repository.ConnectorInputRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AggregatorAppApplicationTests {

	@Autowired
	Route route;

	@Autowired
	TestDispatcher testDispatcher;

	@Autowired
	ConnectorInputRepository connectorInputRepository;

	@MockBean
    SimpleRandomConnector simpleRandomConnector;

	@MockBean
	RoutesScheduler routesScheduler;

	@Test
	void contextLoadsAndRouteWorks() {
		// given
		connectorInputRepository.save(ConnectorInput.builder().value(1024).imported(false).build());
		connectorInputRepository.save(ConnectorInput.builder().value(1024).imported(false).build());
		connectorInputRepository.save(ConnectorInput.builder().value(1024).imported(true).build());

		// when
		route.start();

		//then
		assertEquals(4048, testDispatcher.getValue());
		assertEquals(3, connectorInputRepository.findAllByImported(true).size());
		assertEquals(0, connectorInputRepository.findAllByImported(false).size());
		assertEquals(3, connectorInputRepository.findAll().size());
	}

}

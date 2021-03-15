package io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.repository;

import io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.entity.ConnectorInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectorInputRepository extends JpaRepository<ConnectorInput, Long> {
    List<ConnectorInput> findAllByImported(boolean b);
}

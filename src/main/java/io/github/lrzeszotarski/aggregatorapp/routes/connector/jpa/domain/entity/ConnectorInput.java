package io.github.lrzeszotarski.aggregatorapp.routes.connector.jpa.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConnectorInput {

    @Id
    @GeneratedValue
    private Long id;

    private Integer value;

    private Boolean imported;

}

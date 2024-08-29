package org.epcorps.orderapi.persistence.repository;

import org.epcorps.orderapi.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}

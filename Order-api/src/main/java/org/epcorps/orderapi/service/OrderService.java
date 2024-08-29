package org.epcorps.orderapi.service;

import org.epcorps.orderapi.persistence.entities.OrderEntity;

public interface OrderService {
    public OrderEntity createOrder(OrderEntity order);
    public OrderEntity findOrderById(Long orderId);
    public OrderEntity updateOrder(Long id, OrderEntity order);
    public OrderEntity updateStatusOrder(Long orderId, Boolean status);
    public void deleteOrder(Long id);
}

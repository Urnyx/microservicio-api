package org.epcorps.orderapi.service.impl;

import org.epcorps.orderapi.persistence.entities.OrderEntity;
import org.epcorps.orderapi.persistence.repository.OrderRepository;
import org.epcorps.orderapi.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderEntity findOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Pedido no encontrado"));
    }

    @Override
    public OrderEntity updateOrder(Long id, OrderEntity order) {
        orderRepository.findById(id).orElseThrow(()->new RuntimeException("Pedido no encontrado"));
        return orderRepository.save(order);
    }

    @Override
    public OrderEntity updateStatusOrder(Long orderId, Boolean status) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Pedido no encontrado"));
        orderEntity.setStatus(status);
        return orderRepository.save(orderEntity);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.findById(id).orElseThrow(()->new RuntimeException("Pedido no encontrado"));
        orderRepository.deleteById(id);
    }
}

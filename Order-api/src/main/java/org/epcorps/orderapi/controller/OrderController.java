package org.epcorps.orderapi.controller;

import org.epcorps.orderapi.persistence.entities.OrderEntity;
import org.epcorps.orderapi.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // GET: api/orders/{id}
    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long id) {
        OrderEntity order = orderService.findOrderById(id);
        return ResponseEntity.ok(order);
    }

    // POST: api/orders
    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        OrderEntity newOrder = orderService.createOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    // PUT: api/orders/{id}
    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity order) {
        OrderEntity updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    // PATCH: api/orders/{id}/status
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderEntity> updateOrderStatus(@PathVariable Long id, @RequestParam Boolean status) {
        OrderEntity updatedOrder = orderService.updateStatusOrder(id, status);
        return ResponseEntity.ok(updatedOrder);
    }

    // DELETE: api/orders/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
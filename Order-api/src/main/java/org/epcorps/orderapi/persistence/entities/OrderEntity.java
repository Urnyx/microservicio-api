package org.epcorps.orderapi.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long productId;
    private Long quantity;
    private Boolean status;
}

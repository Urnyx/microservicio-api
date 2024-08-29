package org.epcorps.productosapi.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
@Data
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
}

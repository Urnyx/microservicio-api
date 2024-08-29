package org.epcorps.productosapi.persistence.repository;

import org.epcorps.productosapi.persistence.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}

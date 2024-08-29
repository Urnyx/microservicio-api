package org.epcorps.productosapi.service;

import org.epcorps.productosapi.persistence.ProductEntity;

public interface ProductService {
    ProductEntity saveProduct(ProductEntity product);
    ProductEntity getProductById(String productId);
    ProductEntity updateProduct(String id, ProductEntity product);
    void deleteProductBy(String productId);
}

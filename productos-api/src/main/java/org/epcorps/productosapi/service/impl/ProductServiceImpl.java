package org.epcorps.productosapi.service.impl;

import com.mongodb.DuplicateKeyException;
import org.epcorps.productosapi.persistence.ProductEntity;
import org.epcorps.productosapi.persistence.repository.ProductRepository;
import org.epcorps.productosapi.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    public final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        if(productRepository.findById(product.getId()).isPresent())
            throw new RuntimeException("Error al guardar el producto");
        try {
            // Guardar el producto en la base de datos
            return productRepository.save(product);
        } catch (DuplicateKeyException e) {
            throw new RuntimeException("Error al guardar el producto", e);
        }
    }

    @Override
    public ProductEntity getProductById(String productId) {
        return productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("El producto no existe"));
    }

    @Override
    public ProductEntity updateProduct(String id, ProductEntity product) {
        productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("El producto no existe"));
        return productRepository.save(product);
    }

    @Override
    public void deleteProductBy(String productId) {
        productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("El producto no existe"));
        productRepository.deleteById(productId);
    }
}

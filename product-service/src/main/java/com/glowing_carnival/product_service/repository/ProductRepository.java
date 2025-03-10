package com.glowing_carnival.product_service.repository;


import com.glowing_carnival.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

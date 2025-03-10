package com.glowing_carnival.product_service.controller;


import com.glowing_carnival.product_service.service.ProductService;
import com.glowing_carnival.product_service.dto.ProductRequest;
import com.glowing_carnival.product_service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse CreateProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> GetAllProducts() {
        return productService.getAllProducts();
    }
}

package com.glowing_carnival.order_service.service;

import com.glowing_carnival.order_service.client.InventoryClient;
import com.glowing_carnival.order_service.dto.OrderRequest;
import com.glowing_carnival.order_service.model.Order;
import com.glowing_carnival.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
// @AutoConfigureWireMock(port = ) WIP
public class OrderService {

    private OrderRepository orderRepository;
    private InventoryClient inventoryClient;

    public void placeOrder (OrderRequest orderRequest) {
        boolean isProductAvailable = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        // 1. Use Mockito -> for mocking 
        // 2. Use WireMock
        if (!isProductAvailable){
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not available");
        }

        Order order = new Order();
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setOrderNo(orderRequest.orderNo());
        order.setSkuCode(orderRequest.skuCode());
        orderRepository.save(order);
    }
}

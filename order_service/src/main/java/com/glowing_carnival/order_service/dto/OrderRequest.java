package com.glowing_carnival.order_service.dto;

import jakarta.persistence.Id;

import java.math.BigDecimal;

public record OrderRequest(long Id, BigDecimal price, String orderNo, int quantity, String skuCode) {


}

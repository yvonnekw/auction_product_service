package com.auction.product_service.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Long productId,
        String productName,
        String description,
        BigDecimal buyNowPrice,
        double quantity
) {
}

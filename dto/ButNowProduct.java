package com.auction.product_service.dto;

import jakarta.validation.constraints.NotNull;

public record ButNowProduct(
        @NotNull(message = "Product Id mandatory")
        Long productId,
        @NotNull(message = "Quantity Id mandatory")
        double quantity
) {
}

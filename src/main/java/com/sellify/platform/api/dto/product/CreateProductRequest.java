package com.sellify.platform.api.dto.product;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        String description,
        BigDecimal price
) {}


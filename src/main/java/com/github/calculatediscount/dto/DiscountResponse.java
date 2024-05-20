package com.github.calculatediscount.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DiscountResponse(
        BigDecimal discount,
        BigDecimal amountToPay,
        LocalDateTime calculatedAt
) {
}

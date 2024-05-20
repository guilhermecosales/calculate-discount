package com.github.calculatediscount.dto;

import com.github.calculatediscount.enumerated.PaymentType;

import java.math.BigDecimal;

public record DiscountRequest(
        BigDecimal amount,
        PaymentType paymentType,
        Integer installments
) {
}

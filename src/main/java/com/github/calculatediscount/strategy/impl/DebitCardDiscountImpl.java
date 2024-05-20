package com.github.calculatediscount.strategy.impl;

import com.github.calculatediscount.dto.DiscountRequest;
import com.github.calculatediscount.enumerated.PaymentType;
import com.github.calculatediscount.strategy.PaymentDiscountStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DebitCardDiscountImpl implements PaymentDiscountStrategy {

    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0.10);

    @Override
    public BigDecimal applyDiscount(DiscountRequest request) {
        BigDecimal amount = request.amount();
        return amount.subtract(amount.multiply(DISCOUNT));
    }

    @Override
    public boolean isApplicable(PaymentType paymentType) {
        return paymentType == PaymentType.DEBIT_CARD;
    }

}

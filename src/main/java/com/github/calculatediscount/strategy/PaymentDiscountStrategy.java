package com.github.calculatediscount.strategy;

import com.github.calculatediscount.dto.DiscountRequest;
import com.github.calculatediscount.enumerated.PaymentType;

import java.math.BigDecimal;

public interface PaymentDiscountStrategy {

    BigDecimal applyDiscount(DiscountRequest request);

    boolean isApplicable(PaymentType paymentType);

}

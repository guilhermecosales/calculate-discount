package com.github.calculatediscount.service;

import com.github.calculatediscount.dto.DiscountRequest;
import com.github.calculatediscount.dto.DiscountResponse;
import com.github.calculatediscount.strategy.PaymentDiscountStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiscountService {

    private final List<PaymentDiscountStrategy> paymentDiscountStrategies;

    public DiscountService(List<PaymentDiscountStrategy> paymentDiscountStrategies) {
        this.paymentDiscountStrategies = paymentDiscountStrategies;
    }

    public DiscountResponse calculateDiscount(DiscountRequest request) {
        PaymentDiscountStrategy discountStrategy = paymentDiscountStrategies.stream()
                .filter(strategy -> strategy.isApplicable(request.paymentType()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No discount strategy found for payment type: " + request.paymentType()));

        BigDecimal discountedAmount = discountStrategy.applyDiscount(request);
        BigDecimal discount = discountedAmount.subtract(request.amount());

        return new DiscountResponse(discount, discountedAmount, LocalDateTime.now());
    }

}

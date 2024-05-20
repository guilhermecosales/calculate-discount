package com.github.calculatediscount.controller;

import com.github.calculatediscount.dto.DiscountRequest;
import com.github.calculatediscount.dto.DiscountResponse;
import com.github.calculatediscount.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping
    public ResponseEntity<DiscountResponse> calculate(@RequestBody DiscountRequest request) {
        return ResponseEntity.ok(discountService.calculateDiscount(request));
    }

}

package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.dto.PurchaseOrderRequest;

import java.math.BigDecimal;
import java.util.List;

public class TotalAmountValidator
        implements ConstraintValidator<ValidTotalAmount, PurchaseOrderRequest> {

    @Override
    public boolean isValid(PurchaseOrderRequest request,
                           ConstraintValidatorContext context) {

        if (request == null ||
                request.getItems() == null ||
                request.getTotalAmount() == null) {
            return false;
        }

        BigDecimal calculatedTotal = request.getItems().stream()
                .filter(item -> item.getPrice() != null)
                .map(item -> item.getPrice()
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return calculatedTotal.compareTo(request.getTotalAmount()) == 0;
    }
}
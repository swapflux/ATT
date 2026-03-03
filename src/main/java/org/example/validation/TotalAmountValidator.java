package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.dto.PurchaseOrderRequest;

public class TotalAmountValidator
        implements ConstraintValidator<ValidTotalAmount, PurchaseOrderRequest> {

    @Override
    public boolean isValid(PurchaseOrderRequest request,
                           ConstraintValidatorContext context) {

        if (request == null) {
            return true;
        }

        if (request.getQuantity() == null ||
                request.getPrice() == null ||
                request.getTotalAmount() == null) {
            return false;
        }

        double calculatedAmount =
                request.getQuantity() * request.getPrice();

        return Double.compare(calculatedAmount,
                request.getTotalAmount()) == 0;
    }
}
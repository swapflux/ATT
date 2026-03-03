package org.example.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.validation.ValidTotalAmount;

import java.math.BigDecimal;
import java.util.List;

@ValidTotalAmount
public class PurchaseOrderRequest {

    @NotBlank(message = "Purchase order number cannot be blank")
    private String purchaseOrderNumber;

    @NotNull(message = "Items list cannot be null")
    @Size(min = 1, message = "At least one item is required")
    @Valid
    private List<Item> items;

    @NotNull(message = "Total amount is required")
    private BigDecimal totalAmount;

    // ----------- GETTERS & SETTERS -----------

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
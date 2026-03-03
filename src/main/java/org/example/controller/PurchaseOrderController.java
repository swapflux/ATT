package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.PurchaseOrderRequest;
import org.example.service.PurchaseOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    // Constructor Injection (Best Practice ⭐)
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping
    public ResponseEntity<String> submitOrder(
            @Valid @RequestBody PurchaseOrderRequest request) {

        purchaseOrderService.processOrder(request);

        return ResponseEntity.ok("Order Accepted");
    }
}
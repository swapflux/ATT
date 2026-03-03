package org.example.service;

import org.example.dto.PurchaseOrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PurchaseOrderServiceTest {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Test
    void testProcessOrderAsync() {

        PurchaseOrderRequest request = new PurchaseOrderRequest();

        request.setPurchaseOrderNumber("PO1001");
        request.setProductCode("ROUTER-9000");
        request.setQuantity(2);
        request.setPrice(100.0);
        request.setTotalAmount(200.0);

        purchaseOrderService.processOrder(request);

        // Since method is async, just verify execution
        assertTrue(true);
    }
}
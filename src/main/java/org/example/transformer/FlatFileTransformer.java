package org.example.transformer;

import org.example.dto.PurchaseOrderRequest;
import org.springframework.stereotype.Component;

@Component
public class FlatFileTransformer {

    public String transform(PurchaseOrderRequest request) {

        StringBuilder sb = new StringBuilder();

        sb.append("PO|")
                .append(request.getPurchaseOrderNumber())
                .append("\n");

        request.getItems().forEach(item -> {
            sb.append("ITEM|")
                    .append(item.getProductCode())
                    .append("|")
                    .append(item.getQuantity())
                    .append("|")
                    .append(item.getPrice())
                    .append("\n");
        });

        return sb.toString();
    }
}
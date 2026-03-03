package org.example.transformer;
import org.example.dto.PurchaseOrderRequest;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

@Component
public class FlatFileTransformer {

    public String transformToFlatFile(PurchaseOrderRequest request) {

        try {

            File directory = new File("output");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = "output/po_" +
                    request.getPurchaseOrderNumber() +
                    ".txt";

            // ⭐ Build transformed content (NOT path)
            StringBuilder content = new StringBuilder();

            content.append("PurchaseOrderNumber: ")
                    .append(request.getPurchaseOrderNumber())
                    .append("\n");

            content.append("ProductCode: ")
                    .append(request.getProductCode())
                    .append("\n");

            content.append("Quantity: ")
                    .append(request.getQuantity())
                    .append("\n");

            content.append("Price: ")
                    .append(request.getPrice())
                    .append("\n");

            content.append("TotalAmount: ")
                    .append(request.getTotalAmount())
                    .append("\n");

            content.append("ProcessedTime: ")
                    .append(java.time.LocalDateTime.now());

            return content.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
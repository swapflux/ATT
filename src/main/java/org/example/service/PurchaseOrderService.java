package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.PurchaseOrderRequest;
import org.example.entity.TransactionMetadata;
import org.example.repository.TransactionRepository;
import org.example.transformer.FlatFileTransformer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {

    private final TransactionRepository repository;
    private final FlatFileTransformer transformer;

    public PurchaseOrderService(TransactionRepository repository,
                                FlatFileTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }


    @Async
    public void processOrder(PurchaseOrderRequest request) {

        TransactionMetadata metadata = new TransactionMetadata();
        metadata.setPurchaseOrderNumber(request.getPurchaseOrderNumber());
        metadata.setStatus("RECEIVED");
        metadata.setReceivedAt(LocalDateTime.now());

        repository.save(metadata);

        String fileContent = transformer.transformToFlatFile(request);

        try {
            Files.writeString(
                    Path.of("output/po_" + request.getPurchaseOrderNumber() + ".txt"),
                    fileContent
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
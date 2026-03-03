package org.example.repository;

import org.example.entity.TransactionMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<TransactionMetadata, Long> {
}

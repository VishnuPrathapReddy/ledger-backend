package com.stl.ledger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stl.ledger.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByInvoiceNo(String invoiceNo);

    List<Transaction> findByCompanyId(Long companyId);

    List<Transaction> findByCustomerId(Long companyId);

    boolean existsByInvoiceNo(String invoiceNo);
}

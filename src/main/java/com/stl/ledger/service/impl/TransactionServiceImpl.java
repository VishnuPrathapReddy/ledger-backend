package com.stl.ledger.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stl.ledger.models.Transaction;
import com.stl.ledger.repository.TransactionRepository;
import com.stl.ledger.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {

        if (repository.existsByInvoiceNo(transaction.getInvoiceNo())) {
            throw new RuntimeException("Invoice number already exists.");
        }

        return repository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public List<Transaction> getTransactionsByCustormerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public Transaction getTransactionById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found."));
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {

        Transaction existing = getTransactionById(id);

        existing.setUsername(transaction.getUsername());
        existing.setDate(transaction.getDate());
        existing.setType(transaction.getType());
        existing.setInvoiceNo(transaction.getInvoiceNo());
        existing.setDescription(transaction.getDescription());
        existing.setAmount(transaction.getAmount());
        existing.setPayment(transaction.getPayment());
        existing.setBalance(transaction.getBalance());

        return repository.save(existing);
    }

    @Override
    public void deleteTransaction(Long id) {

        Transaction transaction = getTransactionById(id);

        repository.delete(transaction);
    }
}

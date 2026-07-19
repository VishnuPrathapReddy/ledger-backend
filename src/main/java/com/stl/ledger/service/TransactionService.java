package com.stl.ledger.service;

import java.util.List;

import com.stl.ledger.models.Transaction;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    List<Transaction> getTransactionsByCompanyId(Long companyId);

    List<Transaction> getTransactionsByCustormerId(Long customerId);

    Transaction getTransactionById(Long id);

    Transaction updateTransaction(Long id, Transaction transaction);

    void deleteTransaction(Long id);
}
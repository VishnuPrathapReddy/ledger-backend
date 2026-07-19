package com.stl.ledger.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stl.ledger.models.Transaction;
import com.stl.ledger.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin("*")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(
                service.saveTransaction(transaction),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {

        return ResponseEntity.ok(service.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        
        return ResponseEntity.ok(service.getTransactionById(id));
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<List<Transaction>> getTransactionsByCompanyId(@PathVariable Long companyId) {

        return ResponseEntity.ok(service.getTransactionsByCompanyId(companyId));
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactionsByCustormerId(@PathVariable Long customerId) {

        return ResponseEntity.ok(service.getTransactionsByCustormerId(customerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(
            @PathVariable Long id,
            @RequestBody Transaction transaction) {

        return ResponseEntity.ok(
                service.updateTransaction(id, transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {

        service.deleteTransaction(id);

        return ResponseEntity.ok("Transaction deleted successfully.");
    }
}
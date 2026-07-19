package com.stl.ledger.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
@Table(name = "transactions")

public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TransactionType type;

    @Column(nullable = false, unique = true, length = 30)
    private String invoiceNo;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal payment = BigDecimal.ZERO;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "company_id", length = 100)
    private Long companyId;

    @Column(name = "customer_id", length = 100)
    private Long customerId;


    public Transaction() {
    }

    public Transaction(Long transactionId, String username, LocalDate date, TransactionType type,
                       String invoiceNo, String description,
                       BigDecimal amount, BigDecimal payment,
                       BigDecimal balance, Long companyId, Long customerId) {
        this.transactionId = transactionId;
        this.username = username;
        this.date = date;
        this.type = type;
        this.invoiceNo = invoiceNo;
        this.description = description;
        this.amount = amount;
        this.payment = payment;
        this.balance = balance;
        this.companyId = companyId;
        this.customerId = customerId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

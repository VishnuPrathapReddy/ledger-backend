package com.stl.ledger.models;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "pan_no", length = 10, unique = true)
    private String panNo;

    @Column(name = "mobile_no", length = 15)
    private String mobileNo;

    @Column(name = "email_id", length = 100)
    private String emailId;

    @Column(name = "gst_no", length = 15)
    private String gstNo;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "company_id", length = 100)
    private Long companyId;

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(String username, String name, String panNo, String mobileNo,
                    String emailId, String gstNo,
                    String address, BigDecimal balance, Long companyId) {
        this.username = username;
        this.name = name;
        this.panNo = panNo;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.gstNo = gstNo;
        this.address = address;
        this.balance = balance;
        this.companyId = companyId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}

package com.stl.ledger.models;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String emailId;

    @Column(nullable = false, unique = true, length = 15)
    private String mobileNo;

    @Column(name = "owner_name", length = 100)
    private String ownerName;

    @Column(unique = true, length = 20)
    private String gstNo;

    @Column(length = 255)
    private String address;

    @Column(length = 100)
    private String bankName;

    @Column(length = 100)
    private String branchName;

    @Column(length = 30)
    private String accountNumber;

    @Column(length = 20)
    private String ifscCode;

    @Column(length = 50)
    private String upiId;

    @Column(length = 500)
    private String declaration;

    @Column(name = "user_id", length = 100)
    private Long userId;

    // Default Constructor
    public Company() {
    }

    // Parameterized Constructor
    public Company(Long companyId, String name, String emailId, String mobileNo, String gstNo,
                   String address, String bankName, String branchName,
                   String accountNumber, String ifscCode, String upiId,
                   String declaration, String ownerName, Long userId) {
        this.companyId = companyId;
        this.name = name;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.gstNo = gstNo;
        this.address = address;
        this.bankName = bankName;
        this.branchName = branchName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.upiId = upiId;
        this.declaration = declaration;
        this.ownerName = ownerName;
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
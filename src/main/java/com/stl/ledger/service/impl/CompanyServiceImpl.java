package com.stl.ledger.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stl.ledger.models.Company;
import com.stl.ledger.repository.CompanyRepository;
import com.stl.ledger.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    
    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company saveCompany(Company company) {

        if (repository.existsByEmailId(company.getEmailId())) {
            throw new RuntimeException("Email already exists.");
        }

        if (repository.existsByMobileNo(company.getMobileNo())) {
            throw new RuntimeException("Mobile number already exists.");
        }

        return repository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    @Override
    public List<Company> getCompaniesByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Company getCompanyById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found."));
    }

    @Override
    public Company updateCompany(Long id, Company company) {

        Company existing = getCompanyById(id);

        existing.setName(company.getName());
        existing.setEmailId(company.getEmailId());
        existing.setMobileNo(company.getMobileNo());
        existing.setGstNo(company.getGstNo());
        existing.setAddress(company.getAddress());
        existing.setBankName(company.getBankName());
        existing.setBranchName(company.getBranchName());
        existing.setAccountNumber(company.getAccountNumber());
        existing.setIfscCode(company.getIfscCode());
        existing.setUpiId(company.getUpiId());
        existing.setDeclaration(company.getDeclaration());

        return repository.save(existing);
    }

    @Override
    public void deleteCompany(Long id) {

        Company company = getCompanyById(id);

        repository.delete(company);
    }

}
package com.stl.ledger.service;

import java.util.List;

import com.stl.ledger.models.Company;

public interface CompanyService {

    Company saveCompany(Company company);

    List<Company> getAllCompanies();

    List<Company> getCompaniesByUserId(Long userId);

    Company getCompanyById(Long id);

    Company updateCompany(Long id, Company company);

    void deleteCompany(Long id);

}
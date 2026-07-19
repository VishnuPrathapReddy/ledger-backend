package com.stl.ledger.service;

import java.util.List;

import com.stl.ledger.models.Customer;

public interface CustomerService {
    
    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    List<Customer> getCompaniesByCompanyId(Long companyId);

    Customer getCustomerById(Long id);

    Customer getCustomerByUsername(String username);

    Customer updateCustomer(Long id, Customer customer);

    Customer updateCustomerByUsername(String username, Customer customer);

    void deleteCustomer(Long id);

    void deleteCustomerByUsername(String username);

}

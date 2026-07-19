package com.stl.ledger.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stl.ledger.models.Customer;
import com.stl.ledger.repository.CustomerRepository;
import com.stl.ledger.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public Customer addCustomer(Customer customer) {

        if (repository.existsByUsername(customer.getUsername())) {
            throw new RuntimeException("Username already exists.");
        }

        if (repository.existsByEmailId(customer.getEmailId())) {
            throw new RuntimeException("Email already exists.");
        }

        if (repository.existsByMobileNo(customer.getMobileNo())) {
            throw new RuntimeException("Mobile number already exists.");
        }

        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public List<Customer> getCompaniesByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Customer not found with username: " + username));
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existing = getCustomerById(id);

        existing.setName(customer.getName());
        existing.setPanNo(customer.getPanNo());
        existing.setMobileNo(customer.getMobileNo());
        existing.setEmailId(customer.getEmailId());
        existing.setGstNo(customer.getGstNo());
        existing.setAddress(customer.getAddress());
        existing.setBalance(customer.getBalance());

        return repository.save(existing);
    }

    @Override
    public Customer updateCustomerByUsername(String username, Customer customer) {

        Customer existing = getCustomerByUsername(username);

        existing.setName(customer.getName());
        existing.setPanNo(customer.getPanNo());
        existing.setMobileNo(customer.getMobileNo());
        existing.setEmailId(customer.getEmailId());
        existing.setGstNo(customer.getGstNo());
        existing.setAddress(customer.getAddress());
        existing.setBalance(customer.getBalance());

        return repository.save(existing);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);

        repository.delete(customer);
    }

    @Override
    public void deleteCustomerByUsername(String username) {
        Customer customer = getCustomerByUsername(username);

        repository.delete(customer);
    }
}

package com.stl.ledger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stl.ledger.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    Optional<Customer> findByPanNo(String panNo);

    Optional<Customer> findByEmailId(String emailId);

    Optional<Customer> findByMobileNo(String mobileNo);

    Optional<Customer> findByUsername(String username);

    List<Customer> findByCompanyId(Long companyId);

    boolean existsByEmailId(String email);

    boolean existsByMobileNo(String mobileNo);

    boolean existsByUsername(String username);

}

package com.stl.ledger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stl.ledger.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByEmailId(String email);

    Optional<Company> findByMobileNo(String mobileNo);

    Optional<Company> findByGstNo(String gstNo);

    List<Company> findByUserId(Long userId);

    boolean existsByEmailId(String email);

    boolean existsByMobileNo(String mobileNo);

    boolean existsByGstNo(String gstNo);

    boolean existsByUserId(String userId);
}

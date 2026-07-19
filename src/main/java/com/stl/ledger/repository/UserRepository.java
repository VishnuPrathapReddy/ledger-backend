package com.stl.ledger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stl.ledger.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailId(String email);

    Optional<User> findByMobileNo(String mobileNo);

    Optional<User> findByPanNo(String panNo);

    boolean existsByEmailId(String email);

    boolean existsByMobileNo(String mobileNo);

    boolean existsByPanNo(String panNo);

}
    
    
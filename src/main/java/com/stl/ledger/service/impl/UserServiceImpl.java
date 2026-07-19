package com.stl.ledger.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stl.ledger.models.User;
import com.stl.ledger.repository.UserRepository;
import com.stl.ledger.service.UserService;


@Service
public class UserServiceImpl implements UserService {


    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(
            UserRepository repository,
            PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public User registerUser(User user) {


        if(repository.existsByEmailId(user.getEmailId())) {
            throw new RuntimeException("Email already exists");
        }


        if(repository.existsByMobileNo(user.getMobileNo())) {
            throw new RuntimeException("Mobile number already exists");
        }


        if(user.getPanNo()!=null &&
           repository.existsByPanNo(user.getPanNo())) {

            throw new RuntimeException("PAN already exists");
        }


        // Encrypt password
        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );


        return repository.save(user);
    }



    @Override
    public List<User> getAllUsers() {

        return repository.findAll();
    }



    @Override
    public User getUserById(Long id) {


        return repository.findById(id)
                .orElseThrow(
                () -> new RuntimeException("User not found")
                );
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmailId(email)
                .orElseThrow(
                () -> new RuntimeException("User not found with email: " + email)
                );
    }



    @Override
    public User updateUser(Long id, User user) {

        User existing = getUserById(id);

        existing.setName(user.getName());
        existing.setMobileNo(user.getMobileNo());
        existing.setPanNo(user.getPanNo());

        return repository.save(existing);
    }



    @Override
    public void deleteUser(Long id) {

        User user = getUserById(id);

        repository.delete(user);
    }

}
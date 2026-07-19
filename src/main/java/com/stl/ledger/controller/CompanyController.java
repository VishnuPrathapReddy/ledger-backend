package com.stl.ledger.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stl.ledger.models.Company;
import com.stl.ledger.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin("*")

public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        return new ResponseEntity<>(service.saveCompany(company), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(service.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCompanyById(id));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Company>> getCompaniesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getCompaniesByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(
            @PathVariable Long id,
            @RequestBody Company company) {

        return ResponseEntity.ok(service.updateCompany(id, company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {

        service.deleteCompany(id);

        return ResponseEntity.ok("Company deleted successfully.");
    }
}
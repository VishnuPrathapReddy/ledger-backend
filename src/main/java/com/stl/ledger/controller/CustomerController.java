// package com.stl.ledger.controller;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.stl.ledger.models.Customer;
// import com.stl.ledger.service.CustomerService;

// @RestController
// @RequestMapping("/api/customers")
// @CrossOrigin("*")

// public class CustomerController {
//     private final CustomerService service;

//     public CustomerController(CustomerService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
//         return new ResponseEntity<>(this.service.addCustomer(customer), HttpStatus.CREATED);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
//         return new ResponseEntity<>(this.service.getCustomerById(id),HttpStatus.OK);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Customer> updateCustomerById(@PathVariable Long id, @RequestBody
//         Customer customer
//     ) {
//         return new ResponseEntity<>(this.service.updateCustomer(id, customer), HttpStatus.OK);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
//         this.service.deleteCustomer(id);
//         return ResponseEntity.ok("Customer deleted Succesfully.");
//     }

// }

package com.stl.ledger.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stl.ledger.models.Customer;
import com.stl.ledger.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(
                service.addCustomer(customer),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<List<Customer>> getCompaniesByCompanyId(@PathVariable Long companyId) {
        return ResponseEntity.ok(service.getCompaniesByCompanyId(companyId));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.getCustomerByUsername(username));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomerById(
            @PathVariable Long id,
            @RequestBody Customer customer) {

        return ResponseEntity.ok(service.updateCustomer(id, customer));
    }

    @PutMapping("/username/{username}")
    public ResponseEntity<Customer> updateCustomerByUsername(
            @PathVariable String username,
            @RequestBody Customer customer) {

        return ResponseEntity.ok(service.updateCustomerByUsername(username, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully.");
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity<String> deleteCustomerByUsername(@PathVariable String username) {
        service.deleteCustomerByUsername(username);
        return ResponseEntity.ok("Customer deleted successfully.");
    }
}
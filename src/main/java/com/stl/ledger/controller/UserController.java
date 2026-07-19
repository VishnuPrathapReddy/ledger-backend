package com.stl.ledger.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stl.ledger.models.User;
import com.stl.ledger.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService service;


    public UserController(UserService service) {

        this.service = service;
    }



    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody User user) {


        return new ResponseEntity<>(
                service.registerUser(user),
                HttpStatus.CREATED
        );
    }




    @GetMapping
    public ResponseEntity<List<User>> getAll(){

        return ResponseEntity.ok(
                service.getAllUsers()
        );
    }



    @GetMapping("/{id}")
    public ResponseEntity<User> getById(
            @PathVariable Long id){

        return ResponseEntity.ok(
                service.getUserById(id)
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(
            @PathVariable String email){

        return ResponseEntity.ok(
                service.getUserByEmail(email)
        );
    }




    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable Long id,
            @RequestBody User user){

        return ResponseEntity.ok(
                service.updateUser(id,user)
        );
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id){


        service.deleteUser(id);

        return ResponseEntity.ok(
                "User deleted successfully"
        );
    }

}
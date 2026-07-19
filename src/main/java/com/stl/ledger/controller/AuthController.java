package com.stl.ledger.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.stl.ledger.dto.AuthResponse;
import com.stl.ledger.dto.LoginRequest;
import com.stl.ledger.security.JwtService;



@RestController
@RequestMapping("/api/auth")
public class AuthController {



private final AuthenticationManager authenticationManager;

private final JwtService jwtService;



public AuthController(
        AuthenticationManager authenticationManager,
        JwtService jwtService){

    this.authenticationManager = authenticationManager;
    this.jwtService = jwtService;
}




@PostMapping("/login")
public ResponseEntity<AuthResponse> login(
        @RequestBody LoginRequest request){



    authenticationManager.authenticate(

        new UsernamePasswordAuthenticationToken(
            request.getEmailId(),
            request.getPassword()
        )
    );



    String token =
        jwtService.generateToken(
            request.getEmailId()
        );


    return ResponseEntity.ok(
            new AuthResponse(token)
    );

}

}
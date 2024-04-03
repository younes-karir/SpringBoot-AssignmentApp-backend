package com.youneskarir.assignment.controller;


import com.youneskarir.assignment.dto.AuthenticationRequest;
import com.youneskarir.assignment.dto.RegisterRequest;
import com.youneskarir.assignment.response.ResponseHandle;
import com.youneskarir.assignment.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthenticationController { 
    
    private final AuthenticationService authenticationService;
    
    
    
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterRequest request){
        return ResponseHandle.buildToken(
                "user created",
                HttpStatus.CREATED,
                authenticationService.register(request)
        );
    }


    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody @Valid AuthenticationRequest request){
        return ResponseHandle.buildToken(
                "user authenticated",
                HttpStatus.OK,
                authenticationService.authenticate(request)
        );
    }
    
    
    
    
    
    
}

package com.youneskarir.assignment.service;


import com.youneskarir.assignment.advice.exception.ElementAlreadyExistException;
import com.youneskarir.assignment.dto.AuthenticationRequest;
import com.youneskarir.assignment.dto.RegisterRequest;
import com.youneskarir.assignment.model.Role;
import com.youneskarir.assignment.model.User;
import com.youneskarir.assignment.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final PasswordEncoder  passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final  AuthenticationManager authenticationManager;


    public String register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent())  throw new ElementAlreadyExistException("email already used");
        
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .cohortsDate(LocalDate.now())
                .role(Role.STUDENT)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return jwtService.generateToken(user);
    }

    public Object authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        userRepository.save(user);
        return jwtService.generateToken(user);
    }
}

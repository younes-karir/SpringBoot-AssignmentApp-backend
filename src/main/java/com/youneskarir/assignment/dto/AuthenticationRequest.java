package com.youneskarir.assignment.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationRequest {
    
    @NotEmpty(message = "emil is empty")
    @Email(message = "not a valid email")
    private String email;
    
    @NotEmpty(message = "password is empty")
    @Size(min = 8,message = "password less than 8 characters")
    private String password;
        
}

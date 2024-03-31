package com.youneskarir.assignment.dto;


import com.youneskarir.assignment.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class RegisterRequest {
    
    @NotEmpty(message = "first name is empty")
    private String firstName;
    @NotEmpty(message = "last name is empty")
    private String lastName;
    @NotEmpty(message = "email name is empty")
    @Email(message = "not a valid email")
    private String email;

    @NotEmpty(message = "password is empty")
    @Size(min = 8, message = "password less than 8 characters")
    private String password;  
     
    // to do custom validation 
    private Role role;
}

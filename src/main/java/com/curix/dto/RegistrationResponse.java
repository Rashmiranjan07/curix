package com.curix.dto;

import com.curix.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrationResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}

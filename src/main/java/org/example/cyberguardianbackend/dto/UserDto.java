package org.example.cyberguardianbackend.dto;

import lombok.Data;
import org.example.cyberguardianbackend.enums.UserRole;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private UserRole userRole;
}

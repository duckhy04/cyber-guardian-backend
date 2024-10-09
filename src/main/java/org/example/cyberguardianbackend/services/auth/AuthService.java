package org.example.cyberguardianbackend.services.auth;


import org.example.cyberguardianbackend.dto.SignupRequest;
import org.example.cyberguardianbackend.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
    Boolean hasUserWithEmail(String email);
}

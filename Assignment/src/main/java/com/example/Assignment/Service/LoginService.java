package com.example.Assignment.Service;

import com.example.Assignment.DTO.RegisterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final RegisterService registerService;

    public LoginService(RegisterService registerService) {
        this.registerService = registerService;
    }

    public String login(RegisterDTO data) {

        if (data.getUsername() == null || data.getUsername().isEmpty()) {
            return "Username is required";
        }

        if (data.getPassword() == null || data.getPassword().isEmpty()) {
            return "Password is required";
        }

        for (RegisterDTO user : registerService.getAll()) {
            if (user.getUsername().equals(data.getUsername())) {

                if (user.getPassword().equals(data.getPassword())) {
                    return "Login successful";
                } else {
                    return "Incorrect Password";
                }
            }
        }

        return "User Not Found";
    }

    public RegisterDTO getById(Long id) {
        for (RegisterDTO dto : registerService.getAll()) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }
        return null;
    }

}

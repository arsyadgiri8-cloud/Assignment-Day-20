package com.example.Assignment.Controller;

import com.example.Assignment.DTO.RegisterDTO;
import com.example.Assignment.Service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO DTO) {

        if (DTO.getUsername() == null || DTO.getUsername().isEmpty()) {
            return ResponseEntity.badRequest().body("Username is required");
        }

        if (DTO.getPassword() == null || DTO.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Password is required");
        }

        if (DTO.getEmail() == null || DTO.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        if (DTO.getAddress() == null || DTO.getAddress().isEmpty()) {
            return ResponseEntity.badRequest().body("Address is required");
        }

        registerService.register(DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Register success");
    }
}




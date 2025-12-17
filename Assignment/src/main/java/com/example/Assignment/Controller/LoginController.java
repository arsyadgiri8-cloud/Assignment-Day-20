package com.example.Assignment.Controller;

import com.example.Assignment.DTO.RegisterDTO;
import com.example.Assignment.Service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody RegisterDTO dto) {

        String result = loginService.login(dto);

        if (result.equals("Login successful")) {
            return ResponseEntity.ok(result);
        } else if (result.equals("Incorrect Password")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        } else if (result.equals("User Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}

package com.sellify.platform.api.controller.auth;


import com.sellify.platform.api.dto.auth.AuthResponse;
import com.sellify.platform.api.dto.auth.LoginRequest;
import com.sellify.platform.api.dto.auth.SignUpRequest;
import com.sellify.platform.application.usecase.AuthUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthUseCase authUseCase;

    public AuthController(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @PostMapping("/signup")
    public AuthResponse signup(@Valid @RequestBody SignUpRequest request) {
        return authUseCase.signup(request.email(), request.password());
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authUseCase.login(request.email(), request.password());
    }
}
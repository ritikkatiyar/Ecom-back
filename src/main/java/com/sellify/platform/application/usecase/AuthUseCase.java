package com.sellify.platform.application.usecase;

import com.sellify.platform.api.dto.auth.AuthResponse;
import com.sellify.platform.application.service.UserService;
import com.sellify.platform.infrastructure.multitenancy.TenantContext;
import com.sellify.platform.infrastructure.security.JwtUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthUseCase {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthUseCase(UserService userService,JwtUtil jwtUtil){
        this.userService=userService;
        this.jwtUtil=jwtUtil;
    }
    public AuthResponse signup(String email,String password){
        var user=userService.createUser(email,password);

        String token=jwtUtil.generateToken(
                user.getUserId(),
                TenantContext.getTenantId(),
                List.of("CUSTOMER")
        );
        return new AuthResponse(token);
    }
    public AuthResponse login(String email,String password){
        var user=userService.authenticate(email,password);
        String token=jwtUtil.generateToken(user.getUserId(), TenantContext.getTenantId(),
                List.of("CUSTOMER"));
        return new AuthResponse(token);
    }
}

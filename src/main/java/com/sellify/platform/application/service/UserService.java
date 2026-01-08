package com.sellify.platform.application.service;

import com.sellify.platform.infrastructure.multitenancy.TenantContext;
import com.sellify.platform.infrastructure.persistence.entity.UserEntity;
import com.sellify.platform.infrastructure.persistence.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public UserEntity createUser(String email,String password){
        UserEntity user=new UserEntity();
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
    public UserEntity authenticate(String email,String password){
        return userRepository.
                findByEmailAndTenantId(email, TenantContext.getTenantId())
                .filter(u->passwordEncoder.matches(password,u.getPasswordHash()))
                .orElseThrow(()->new RuntimeException("Invalid credentials"));
    }
}

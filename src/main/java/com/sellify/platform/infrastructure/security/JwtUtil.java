package com.sellify.platform.infrastructure.security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.List;

@Component
public class JwtUtil {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_MS=60*60*1000;


    public static String generateToken(String userId, String tenantId, List<String> roles){
        return Jwts.builder()
                .setSubject();
    }
}

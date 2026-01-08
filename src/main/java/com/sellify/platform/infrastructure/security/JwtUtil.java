package com.sellify.platform.infrastructure.security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_MS=60*60*1000;


    public String generateToken(String userId, String tenantId, List<String> roles){
        return Jwts.builder()
                .setSubject(userId)
                .claim("tenantId",tenantId)
                .claim("roles",roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_MS))
                .signWith(key)
                .compact();
    }
    public Claims validateToken(String token){
      return Jwts.parserBuilder()
              .setSigningKey(key)
              .build()
              .parseClaimsJws(token)
              .getBody();
    }
}

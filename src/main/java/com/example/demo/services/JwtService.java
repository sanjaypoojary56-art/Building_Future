package com.example.demo.services;

import com.example.demo.Entities.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    private static final String k="my_key_for#the(progarm_125632_)-is-this2343576787";
    SecretKey key=Keys.hmacShaKeyFor(k.getBytes(StandardCharsets.UTF_8));
    public String generateToken(Users user){
        return Jwts.builder().setSubject(user.getEmail()).claim("role",user.getRole()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+1000*60*60)).signWith(key).compact();
    }
    public String extarctEmail(String token) {
        Claims claim= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claim.getSubject();


    }

    public String extractRole(String token) {
        Claims claim= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

        return claim.get("role", String.class);
    }
}

package com.plafip.api.infra.service;

import com.plafip.api.domain.model.User;
import com.plafip.api.domain.port.SecurityService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;

public class PlafipSecurityService implements SecurityService {

    private final String secret;
    private final long expiration;

    public PlafipSecurityService(String secret, long expiration){
        this.secret = secret;
        this.expiration = expiration;
    }

    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .claim("name", user.getUsername())
                .claim("email", user.getEmail())
                .claim("role", List.of("user"))
                .setIssuer("plafip")
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}

package com.gl.exercice.apiusers.services.impl;

import com.gl.exercice.apiusers.services.IJWTService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JWTServiceImpl implements IJWTService {

    @Override
    public String generateJWTToken(String username) {
        String secretKey = "secret_key";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        JwtBuilder builder = Jwts.builder();

        // id
        builder.setId(UUID.randomUUID().toString());

        // subject
        builder.setSubject(username);

        // claims
        List<String> listAuth = grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        builder.claim("authorities", listAuth);


        builder.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,secretKey.getBytes()).compact();

        return "Bearer " + builder.compact();
    }

}

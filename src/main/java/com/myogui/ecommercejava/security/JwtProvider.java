package com.myogui.ecommercejava.security;

import com.myogui.ecommercejava.utils.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtProvider implements Serializable {

    public String getJWTToken(String username) {
        var grantedAuthorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(Constants.ROLE);

        return Jwts.builder()
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60000)) //properties
                .signWith(SignatureAlgorithm.HS512, "springbootjwt".getBytes()) //properties TODO
                .compact();
    }

}

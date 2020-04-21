package org.sterzhen.ypmtool.security.impl;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.sterzhen.ypmtool.security.JWTTokenAuthentication;
import org.sterzhen.ypmtool.security.JwtTokenService;

import java.time.Instant;

public class JWTAuthenticationProvider implements AuthenticationProvider {

    private final JwtTokenService jwtTokenService;
    private final UserDetailsService userDetailsService;

    public JWTAuthenticationProvider(JwtTokenService jwtTokenService, UserDetailsService userDetailsService) {
        this.jwtTokenService = jwtTokenService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        JWTTokenAuthentication tokenAuthentication = (JWTTokenAuthentication) authentication;
        var token = tokenAuthentication.getCredentials();

        Instant expiredDate = jwtTokenService.getExpiredDate(token)
                .orElseThrow(() -> new AuthenticationServiceException("Invalid token"));

        if (expiredDate.isAfter(Instant.now())) {
            User user = (User) userDetailsService.loadUserByUsername(tokenAuthentication.getName());
            tokenAuthentication.setAuthenticated(true);
            tokenAuthentication.setDetails(user);
        } else {
            throw new AuthenticationServiceException("Token expired date error");
        }

        return tokenAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == JWTTokenAuthentication.class;
    }
}

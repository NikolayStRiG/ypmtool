package org.sterzhen.ypmtool.security;

import org.springframework.security.web.authentication.AuthenticationConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class JWTAuthenticationConverter implements AuthenticationConverter {

    public static final String X_AUTH_TOKEN = "X-Auth-Token";
    private final JwtTokenService jwtTokenService;

    public JWTAuthenticationConverter(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public JWTTokenAuthentication convert(HttpServletRequest request) {

        return Optional.ofNullable(request.getHeader(X_AUTH_TOKEN))
                .flatMap(token -> jwtTokenService.getUserName(token)
                        .map(s -> new JWTTokenAuthentication(s, token)))
                .orElse(null);
    }
}

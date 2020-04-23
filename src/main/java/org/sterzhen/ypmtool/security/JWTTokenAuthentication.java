package org.sterzhen.ypmtool.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class JWTTokenAuthentication extends AbstractAuthenticationToken {

    private final String userName;
    private final String jwtToken;

    public JWTTokenAuthentication(String userName, String jwtToken) {
        super(null);
        this.userName = userName;
        this.jwtToken = jwtToken;
        setAuthenticated(false);
    }

    public JWTTokenAuthentication(String userName, String jwtToken, User user) {
        super(user != null ? user.getAuthorities() : Collections.emptyList());
        this.userName = userName;
        this.jwtToken = jwtToken;
        setAuthenticated(user != null);
    }

    @Override
    public String getCredentials() {
        return jwtToken;
    }

    @Override
    public Object getPrincipal() {
        return userName;
    }


}

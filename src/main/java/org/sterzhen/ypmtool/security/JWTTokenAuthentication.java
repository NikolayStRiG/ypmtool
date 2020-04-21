package org.sterzhen.ypmtool.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JWTTokenAuthentication extends AbstractAuthenticationToken {

    private final String userName;
    private final String jwtToken;

    public JWTTokenAuthentication(String userName, String jwtToken) {
        super(null);
        this.userName = userName;
        this.jwtToken = jwtToken;
        setAuthenticated(false);
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

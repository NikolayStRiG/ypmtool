package org.sterzhen.ypmtool.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class TokenAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        if (e instanceof AuthenticationServiceException) {
            httpServletResponse.sendError(HttpServletResponse.SC_PRECONDITION_FAILED, e.getMessage());
        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
}

package org.sterzhen.ypmtool.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.Logger.Level.DEBUG;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private static final System.Logger LOGGER = System.getLogger(JWTAuthenticationFilter.class.getName());

    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(JwtTokenService jwtTokenService, AuthenticationManager authenticationManager) {
        this.jwtTokenService = jwtTokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        LOGGER.log(DEBUG, "Start authentication filter");

        try {
            JWTTokenAuthentication authRequest = new JWTAuthenticationConverter(jwtTokenService).convert(request);
            if (authRequest == null) {
                chain.doFilter(request, response);
                return;
            }

            String username = authRequest.getName();

            LOGGER.log(DEBUG, "Basic Authentication Authorization header found for user '" + username + "'");

            Authentication authResult = this.authenticationManager.authenticate(authRequest);

            LOGGER.log(DEBUG, "Authentication success: " + authResult);

            SecurityContextHolder.getContext().setAuthentication(authResult);

        } catch (AuthenticationException failed) {
            SecurityContextHolder.clearContext();
            LOGGER.log(DEBUG, "Authentication request for failed: " + failed);
            return;
        }
        chain.doFilter(request, response);
    }
}

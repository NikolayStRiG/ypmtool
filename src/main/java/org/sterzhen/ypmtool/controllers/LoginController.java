package org.sterzhen.ypmtool.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sterzhen.ypmtool.data.dto.UserDTO;
import org.sterzhen.ypmtool.security.JwtTokenService;
import org.sterzhen.ypmtool.servises.ToolUserService;

import javax.persistence.EntityNotFoundException;

@CrossOrigin
@RestController
public class LoginController {

    private final JwtTokenService jwtTokenService;
    private final ToolUserService userService;

    public LoginController(JwtTokenService jwtTokenService, ToolUserService userService) {
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    public TokenBean login(Authentication auth) {
        return new TokenBean(jwtTokenService.getToken(auth.getName()));
    }

    @GetMapping(path = "/current_user")
    public UserDTO getCurrentUser(Authentication auth) {
        return userService.findByLogin(auth.getName())
                .map(UserDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("User with login " + auth.getName() + " not found"));
    }

    public static class TokenBean {

        private final String token;

        public TokenBean(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}

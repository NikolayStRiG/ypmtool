package org.sterzhen.ypmtool.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {

    @PostMapping(path = "/login")
    public TokenBean login() {
        return new TokenBean("token");
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

package org.sterzhen.ypmtool.security.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.sterzhen.ypmtool.security.JwtTokenService;

import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JwtTokenServiceImpl implements JwtTokenService {

    public static final String USER_NAME = "username";
    public static final String TOKEN_CREATE_DATE = "token_create_date";
    public static final String TOKEN_EXPIRATION_DATE = "token_expiration_date";
    private final String key;
    private final TemporalAmount validityPeriod;

    public JwtTokenServiceImpl(String key, TemporalAmount validityPeriod) {
        this.key = key;
        this.validityPeriod = validityPeriod;
    }

    @Override
    public String getToken(String username) {
        if (username == null) {
            return null;
        }
        Map<String, Object> tokenData = new HashMap<>();
        tokenData.put(USER_NAME, username);
        var createDate = Instant.now();
        tokenData.put(TOKEN_CREATE_DATE, createDate.toEpochMilli());
        tokenData.put(TOKEN_EXPIRATION_DATE, createDate.plus(validityPeriod).toEpochMilli());
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(Date.from(createDate));
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();
    }

    @Override
    public Optional<String> getUserName(String jwtToken) {
        var claims = (Claims) Jwts.parser().setSigningKey(key).parse(jwtToken).getBody();
        return Optional.ofNullable(claims.get(USER_NAME, String.class));
    }

    @Override
    public Optional<Instant> getExpiredDate(String jwtToken) {
        var claims = (Claims) Jwts.parser().setSigningKey(key).parse(jwtToken).getBody();
        return Optional.ofNullable(claims.get(TOKEN_EXPIRATION_DATE, Long.class))
                .map(Instant::ofEpochMilli);
    }
}

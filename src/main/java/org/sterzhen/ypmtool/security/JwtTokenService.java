package org.sterzhen.ypmtool.security;

import java.time.Instant;
import java.util.Optional;

public interface JwtTokenService {

    String getToken(String username);

    Optional<String> getUserName(String jwtToken);

    Optional<Instant> getExpiredDate(String jwtToken);
}

package com.scaler.blogapp.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JWTServiceTests {

    JWTService jwtService = new JWTService();

    @Test
    void canCreateJwtFromUserId () {
        var jwt = jwtService.createJwt(1001L);

        assertNotNull(jwt);
    }
}

package com.stark.homework.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtAuthenticationTest {

    @Test
    void generateJwtToken() {
        String token = JwtAuthentication.generateJwtToken(1, "stark");
        System.out.println(JwtAuthentication.authentication(token, 1, "stark"));
    }
}
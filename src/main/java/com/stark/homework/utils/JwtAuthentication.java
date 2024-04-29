package com.stark.homework.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JwtAuthentication {

    // 加密算法
    private final static SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    // 私钥
    private final static String secret = "com.stark.homework";

    // 过期时间（两小时）
    private final static Long access_token_expiration = 7200L;

    // 签发者
    private final static String signer = "stark";

    // 所有人
    private final static String owner = "stark";

    /**
     * 为用户生成 Jwt Token
     *
     * @param id       用户 id
     * @param username 用户名
     * @return 返回 Jwt Token
     */
    public static String generateJwtToken(int id, String username) {
        // 设置 Jwt 头部
        Map<String, Object> head = new HashMap<>();
        head.put("alg", "HS256");
        head.put("typ", "JWT");

        // 设置 Jwt 载荷
        Map<String, Object> claims = new HashMap<String, Object>();

        // 私有声明
        claims.put("id", id);
        claims.put("username", username);
        // 签发者
        claims.put("iss", signer);

        // 返回 Jwt Token
        return Jwts.builder()
                .setHeader(head)
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + access_token_expiration * 1000))
                .setSubject(owner)
                .signWith(SIGNATURE_ALGORITHM, secret)
                .compact();
    }

    public static boolean authentication(String jwt, int id, String username) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
            return claims.get("id").equals(id) && claims.get("username").equals(username);
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }
}

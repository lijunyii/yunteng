package com.yunteng.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtils {


    // 安全配置参数（生产环境应从配置中心读取）
    private static final String SECRET_KEY = "your-256-bit-secret-key-1234567890";
    private static final String ISSUER = "tlias-system";
    private static final long EXPIRATION_MS = 86400000; // 24小时
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    /**
     * 生成 JWT 令牌
     * @param userId   用户ID
     * @param role     用户角色
     * @return 有效的 JWT 令牌
     */
    public static String generateToken(String userId, String role) {
        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(userId)
                    .withClaim("role", role)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                    .sign(ALGORITHM);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("JWT 生成失败", ex);
        }
    }

    /**
     * 验证并解析 JWT 令牌
     * @param token 待验证的令牌
     * @return 解码后的 JWT 信息
     * @throws JWTVerificationException 验证失败时抛出异常
     */
    public static DecodedJWT verifyToken(String token) throws JWTVerificationException {
        return JWT.require(ALGORITHM)
                .withIssuer(ISSUER)
                .build()
                .verify(token);
    }
}

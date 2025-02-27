package com.yunteng;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.yunteng.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {
    // 测试用户数据
    private static final String TEST_USER_ID = "user-123";
    private static final String TEST_ROLE = "STUDENT";

    @Test
    void testGenerateAndVerifyToken() {

        // 生成令牌
        String token = JwtUtils.generateToken(TEST_USER_ID, TEST_ROLE);

        // 验证令牌
        DecodedJWT jwt = assertDoesNotThrow(
                () -> JwtUtils.verifyToken(token),
                "有效令牌应验证通过"
        );

        // 验证令牌内容
        assertEquals(TEST_USER_ID, jwt.getSubject(), "用户ID不匹配");
        assertEquals(TEST_ROLE, jwt.getClaim("role").asString(), "用户角色不匹配");
        assertEquals("tlias-system", jwt.getIssuer(), "签发者不匹配");
        assertTrue(jwt.getExpiresAt().after(new Date()), "令牌应未过期");
    }
}


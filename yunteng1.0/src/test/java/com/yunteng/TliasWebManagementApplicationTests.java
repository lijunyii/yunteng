package com.yunteng;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAccessProtectedApiWithoutToken() throws Exception {
        mockMvc.perform(get("/api/students"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testAccessWithValidToken() throws Exception {
        String validToken = "your_generated_jwt_token";
        mockMvc.perform(get("/api/students")
                        .header("Authorization", "Bearer " + validToken))
                .andExpect(status().isOk());
    }

}

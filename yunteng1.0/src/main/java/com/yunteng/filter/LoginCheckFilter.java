package com.yunteng.filter;

import com.yunteng.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    // 假设的密钥，实际应用中需要更安全的处理方式
    private static final String SECRET_KEY = "yourSecretKeyHere32ByteKey1234567890abcdef";
    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取请求url
        String url = request.getRequestURI().toString();
        log.info("url:{}", url);


        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if(url.contains("login")){
            log.info("login");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //3.获取请求头中的令牌
        String jwt = request.getHeader("token");


        //4.判断令牌是否存在，如果不存在，登录失败
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录的信息");
            // 使用jjwt-jackson相关方式构建响应
            response.setContentType("application/json;charset=utf-8");
            Claims claims = Jwts.claims();
            claims.put("msg", "NOT_LOGIN");
            String notLoginJson = Jwts.builder()
                    .setClaims(claims)
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
            response.getWriter().write(notLoginJson);
            return;
        }
        //5.解析token，解析失败，登录失败
        try{
            JwtUtils.verifyToken(jwt);
            filterChain.doFilter(servletRequest, servletResponse);
        }catch (Exception e){
            //jwt解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            // 使用jjwt-jackson相关方式构建响应
            response.setContentType("application/json;charset=utf-8");
            Claims claims = Jwts.claims();
            claims.put("msg", "NOT_LOGIN");
            String notLoginJson = Jwts.builder()
                    .setClaims(claims)
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
            response.getWriter().write(notLoginJson);
        }
        }

    }



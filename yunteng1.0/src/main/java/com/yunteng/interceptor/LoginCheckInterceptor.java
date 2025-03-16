package com.yunteng.interceptor;

import com.yunteng.pojo.Result;
import com.yunteng.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.InstanceFilter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源方法运行前，返回true：放行，返回false，不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求url
        String url = request.getRequestURI().toString();
        log.info("url:{}", url);
        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if(url.contains("login")){
            log.info("login");
            return true;
        }
        //3.获取请求头中的令牌
        //String jwt = request.getHeader("authToken");
        // System.out.println(authToken);
        String jwt = request.getParameter("authToken");
        if (jwt == null) {
            jwt = request.getHeader("authToken");
        }
        System.out.println(jwt);
        //4.判断令牌是否存在，如果不存在，登录失败
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录的信息 2");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json
//            String notLogin = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLogin);
            request.setAttribute("error",error);
            return false;
        }
        //5.解析token，解析失败，登录失败
        try{
            JwtUtils.verifyToken(jwt);
        }catch (Exception e){
            //jwt解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result  error = Result.error("NOT_LOGIN");
            //手动转换 对象--json
//            String notLogin = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLogin);
            request.setAttribute("error",error);
            return false;
        }
        //6.放行
        log.info("令牌合法，放行");
        return true;
    }

}

package com.yunteng.controller;

import com.yunteng.pojo.Manage;
import com.yunteng.pojo.Result;
import com.yunteng.service.ManageService;
import com.yunteng.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class ManageLoginController {
    @Autowired
    private ManageService manageService;

    @PostMapping("/login")
    public Result login(@RequestBody Manage manage) {
        // 参数校验
        if (manage == null || manage.getUsername() == null || manage.getPassword() == null) {
            log.error("用户名或密码为空，登录失败");
            return Result.error("用户名或密码为空");
        }

        try {
            Manage e = manageService.login(manage.getUsername(), manage.getPassword());
            if (e != null) {
                String token = JwtUtils.generateToken(manage.getUsername(), manage.getPassword());
                log.info("用户{} 登录成功，生成令牌: {}", manage.getUsername(), token);
                return Result.success(token);
            } else {
                log.info("用户名或密码错误，登录失败");
                return Result.error("用户名或密码错误");
            }
        } catch (Exception ex) {
            log.error("登录过程中发生异常: {}", ex.getMessage(), ex);
            return Result.error("登录失败，请联系其他管理员");
        }
    }
}




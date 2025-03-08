package com.yunteng.controller;

import com.yunteng.pojo.Emp;
import com.yunteng.pojo.Result;
import com.yunteng.service.EmpService;
import com.yunteng.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ... existing code ...
// 明确指定路径
@RequestMapping("/api")
@Slf4j
@RestController
public class EmpLoginController {
    @Autowired
    private EmpService empService;

    // 删除未使用的字段
    // private Object empList;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        // 参数校验
        if (emp == null || emp.getUsername() == null || emp.getPassword() == null) {
            log.error("用户名或密码为空，登录失败");
            return Result.error("用户名或密码为空");
        }

        try {
            Emp e = empService.login(emp.getUsername(), emp.getPassword());
            if (e != null) {
                String token = JwtUtils.generateToken(emp.getUsername(), emp.getPassword());
                log.info("用户{} 登录成功，生成令牌: {}", emp.getUsername(), token);
                return Result.success(token);
            } else {
                log.info("用户名或密码错误，登录失败");
                return Result.error("用户名或密码错误");
            }
        } catch (Exception ex) {
            log.error("登录过程中发生异常: {}", ex.getMessage(), ex);
            return Result.error("登录失败，请联系管理员");
        }
    }
}




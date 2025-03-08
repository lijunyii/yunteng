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

    @PostMapping("/manage/login")
    public Result login(@RequestBody Manage manage) {
        // 参数校验
        try{
            if(manage==null){
                log.error("用户不存在");
                return Result.error("用户不存在，请注册");
            }
            if(manage.getUsername()==null||manage.getPassword()==null){
                log.error("用户名或密码为空，登录失败");
                return Result.error("用户名或密码不能为空，请填写用户名和密码");
            }

            Manage m=manageService.login(manage.getUsername(),manage.getPassword());
            if(m==null){log.error("用户名或密码不正确，请重新输入");
                return Result.error("用户名或密码不正确，请重新输入");
            }else{
                String jwt=JwtUtils.generateToken(manage.getUsername(),manage.getPassword());
                log.info("用户{}登录成功，生成令牌{}",manage.getUsername(),jwt);
                return Result.success(jwt);
            }

        } catch (Exception e) {
            log.error("系统出现异常");
            return Result.error("系统出现异常，请联系后台管理员");
        }
    }
}
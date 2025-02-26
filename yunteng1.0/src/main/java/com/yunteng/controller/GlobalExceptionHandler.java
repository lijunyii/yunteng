package com.yunteng.controller;

import com.yunteng.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有未捕获的异常
     * @param e 异常对象
     * @return 统一的结果对象
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("发生异常: ", e);
        return Result.error("服务器内部错误，请稍后重试");
    }
}

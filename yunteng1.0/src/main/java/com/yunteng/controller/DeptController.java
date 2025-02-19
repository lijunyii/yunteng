package com.yunteng.controller;

import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.yunteng.service.DeptService;


/**
 * 部门管理Controller
 */
@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list(){
        log.info("查询全部部门数据");
        //调用service查询数据库
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }
}

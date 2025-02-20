package com.yunteng.controller;

import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 查询全部部门数据
     * @return
     */
    @GetMapping("/depts")
    public Result list(){
        log.info("查询全部部门数据");
        //调用service查询数据库
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @return
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }
}

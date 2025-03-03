package com.yunteng.controller;

import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Emp;
import com.yunteng.pojo.Result;
import com.yunteng.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 学生管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private final EmpService empService;
    private Object empList;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    /**
     * 新增学生
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增学生，emp:{}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 查询全部学生数据
     */
    @GetMapping
    public Result list() {
        log.info("查询全部学生数据");
        try {
            // 调用service查询数据库
            List<Emp> empList = empService.list();
            return Result.success(empList);
        } catch (Exception e) {
            log.error("查询学生数据时发生异常: ", e);
            return Result.error("查询学生数据失败，请稍后重试");
        }
    }

    // 根据ID删除员工
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        log.info("根据学生id删除学生: {}", id);
        empService.deleteEmp(id);
        return ResponseEntity.ok().build();
    }
}





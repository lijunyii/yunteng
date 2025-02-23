package com.yunteng.controller;

import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @return 包含部门列表的结果对象
     */
    @GetMapping("/depts")
    public Result list() {
        log.info("查询全部部门数据");
        try {
            // 调用service查询数据库
            List<Dept> deptList = deptService.list();
            return Result.success(deptList);
        } catch (Exception e) {
            log.error("查询部门数据时发生异常: ", e);
            return Result.error("查询部门数据失败，请稍后重试");
        }
    }

    /**
     * 删除部门
     * @param id 部门ID
     * @return 操作结果对象
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);
        try {
            // 调用service删除部门
            deptService.delete(id);
            return Result.success();
        } catch (Exception e) {
            log.error("删除部门时发生异常: ", e);
            return Result.error("删除部门失败，请稍后重试");
        }
    }

    /**
     * 添加部门
     * @param dept 部门对象
     * @return 操作结果对象
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门:{}", dept);
        try {
            // 调用service添加部门
            deptService.add(dept);
            return Result.success();
        } catch (Exception e) {
            log.error("添加部门时发生异常: ", e);
            return Result.error("添加部门失败，请稍后重试");
        }
    }
}

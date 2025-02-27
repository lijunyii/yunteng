package com.yunteng.controller;

import com.yunteng.pojo.Manage;
import com.yunteng.service.ManageService;
import org.springframework.web.bind.annotation.RestController;
import com.yunteng.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.yunteng.service.ManageService;

/**
 * 管理员管理Controller
 */
@Slf4j
@RestController
public class ManageController {
     @Autowired
    private ManageService ManageService;

    /**
     * 查询全部管理员数据
     * @return 包含部门列表的结果对象
     */
    @GetMapping("/manages")
    public Result list() {
        log.info("查询全部管理员数据");
        try {
            // 调用service查询数据库
            List<Manage> manageList = ManageService.list();
            return Result.success(manageList);
        } catch (Exception e) {
            log.error("查询管理员数据时发生异常: ", e);
            return Result.error("查询管理员数据失败，请稍后重试");
        }
    }

    /**
     * 删除管理员
     * @param id 管理员ID
     * @return 操作结果对象
     */
    @DeleteMapping("/manages/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除管理员:{}", id);
        try {
            // 调用service删除部门
            ManageService.delete(id);
            return Result.success();
        } catch (Exception e) {
            log.error("删除管理员时发生异常: ", e);
            return Result.error("删除管理员失败，请稍后重试");
        }
    }

    /**
     * 添加管理员
     * @param manage 管理员对象
     * @return 操作结果对象
     */
    @PostMapping("/manages")
    public Result add(@RequestBody Manage manage) {
        log.info("添加管理员:{}", manage);
        try {
            // 调用service添加部门
            ManageService.add(manage);
            return Result.success();
        } catch (Exception e) {
            log.error("添加管理员时发生异常: ", e);
            return Result.error("添加管理员失败，请稍后重试");
        }
    }
}

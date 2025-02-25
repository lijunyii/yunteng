package com.yunteng.controller;

import com.yunteng.pojo.Announcement;
import com.yunteng.pojo.Result;
import com.yunteng.service.AnnouncementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告栏控制器
 */
@RestController
@RequestMapping("/announcements")
@Slf4j
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    /**
     * 查询公告列表
     * @return
     */
    @GetMapping("/list")
    public Result list() {
        log.info("查询公告列表...");
        List<Announcement> announcements = announcementService.list();
        return Result.success(announcements);
    }

    /**
     * 删除公告
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除公告：{}", id);
        announcementService.delete(id);
        return Result.success();
    }

    /**
     * 添加公告
     * @param announcement
     * @return
     */
    @PostMapping()
    public Result add(@RequestBody Announcement announcement) {
        log.info("添加公告：{}", announcement);
        announcementService.add(announcement);
        return Result.success();
    }


}
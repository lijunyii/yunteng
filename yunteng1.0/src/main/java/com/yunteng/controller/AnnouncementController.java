package com.yunteng.controller;

import com.yunteng.pojo.Announcement;
import com.yunteng.pojo.Result;
import com.yunteng.service.AnnouncementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 公告栏控制器
 */
@RestController
@RequestMapping("/announcement")
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
}
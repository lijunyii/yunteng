package com.yunteng.service;

import com.yunteng.pojo.Announcement;

import java.util.List;

public interface AnnouncementService {
    /**
     * 查询公告列表
     * @return
     */
    List<Announcement> list();
}

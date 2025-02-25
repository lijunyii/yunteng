package com.yunteng.service;


import com.yunteng.pojo.Announcement;
import java.util.List;
/**
 * 公告服务接口
 */
public interface AnnouncementService {
    /**
     * 查询公告列表
     * @return
     */
    List<Announcement> list();

    /**
     * 删除公告
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 添加公告
     * @param announcement
     */
    void add(Announcement announcement);

}

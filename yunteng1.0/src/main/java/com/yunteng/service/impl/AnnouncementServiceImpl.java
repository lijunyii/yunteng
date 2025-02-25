package com.yunteng.service.impl;

import com.yunteng.mapper.AnnouncementMapper;
import com.yunteng.pojo.Announcement;
import com.yunteng.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> list() {
        return announcementMapper.list();
    }

    @Override
    public void delete(Integer id) {
    announcementMapper.deleteById(id);
    }

    @Override
    public void add(Announcement announcement) {
        announcement.setCreateTime(LocalDateTime.now());
        announcement.setUpdateTime(LocalDateTime.now());
       announcementMapper.insert(announcement);}

}

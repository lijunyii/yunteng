package com.yunteng.service.impl;

import com.yunteng.mapper.AnnouncementMapper;
import com.yunteng.pojo.Announcement;
import com.yunteng.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> list() {
        return announcementMapper.list();
    }
}

package com.yunteng.service.impl;

import com.yunteng.mapper.ManageMapper;
import com.yunteng.pojo.Manage;
import com.yunteng.service.ManageService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManageServicelmpl implements ManageService {
     @Autowired
    private ManageMapper manageMapper;

    @Override
    public List<Manage> list() {return manageMapper.list();}

    @Override
    public void delete(Integer id) {
        manageMapper.deleteById(id);
    }

    @Override
    public void add(Manage manage) {
        manage.setCreateTime(LocalDateTime.now());
        manage.setUpdateTime(LocalDateTime.now());
        manageMapper.insert(manage);
    }
}